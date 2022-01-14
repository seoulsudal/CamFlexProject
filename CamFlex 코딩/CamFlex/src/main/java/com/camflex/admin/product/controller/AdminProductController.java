package com.camflex.admin.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.product.service.AdminProductService;
import com.camflex.admin.product.vo.AdminProductVO;
import com.camflex.common.file.FileUploadUtil;
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;

@Controller
@RequestMapping(value = "/admin/product")
public class AdminProductController {

	private Logger log = LoggerFactory.getLogger(AdminProductController.class);
	private HttpSession session;
	private String m_id;

	
	@Autowired
	private AdminProductService adminProductService;
	
	/************************************
	 * 상품 목록 구현
	 ************************************/
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String productList(@ModelAttribute("pgrq")PageRequest pageRequest, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		
		log.info("상품 목록 호출 성공");

		// List<ProductVO> productList = adminProductService.productList(pvo);

		model.addAttribute("productList", adminProductService.productList(pageRequest));
		model.addAttribute("id", m_id);
		//model.addAttribute("data", pvo);

		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(adminProductService.count(pageRequest));
		model.addAttribute("pagination", pagination);
		
		return "admin/product/productList";
	}
	
	/*************************************
	 * 상품 등록 폼 출력
	 ************************************/
	@RequestMapping(value = "/regProduct", method = RequestMethod.GET)
	public String regForm(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		log.info("상품 등록 폼 호출 성공");
		
		model.addAttribute("id", m_id);
		
		return "admin/product/regProduct";
	}

	/*************************************
	 * 상품 등록 구현
	 *************************************/
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String regProduct(@ModelAttribute AdminProductVO pvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		log.info("상품 등록 호출");
		log.info("fileName : " + pvo.getFile().getOriginalFilename());
		log.info("fileName : " + pvo.getFile1().getOriginalFilename());
		log.info("fileName : " + pvo.getFile2().getOriginalFilename());
		log.info("fileName : " + pvo.getFile3().getOriginalFilename());
		int result = 0;
		String url = "";

		if (pvo.getFile() != null) {
			String p_mainphoto = FileUploadUtil.fileUpload(pvo.getFile(), request, "product");
			pvo.setP_mainphoto(p_mainphoto);
		}
		if (pvo.getFile1() != null) {
			String p_photo1 = FileUploadUtil.fileUpload1(pvo.getFile1(), request, "product");
			pvo.setP_photo1(p_photo1);
		}
		if (pvo.getFile2() != null) {
			String p_photo2 = FileUploadUtil.fileUpload2(pvo.getFile2(), request, "product");
			pvo.setP_photo2(p_photo2);
		}
		if (pvo.getFile3() != null) {
			String p_photo3 = FileUploadUtil.fileUpload3(pvo.getFile3(), request, "product");
			pvo.setP_photo3(p_photo3);
		}
		result = adminProductService.regProduct(pvo);
		if (result == 1) {
			url = "/admin/product/productList";
		} else {
			model.addAttribute("code", 1);
			url = "/admin/product/regProduct";
		}
		return "redirect:" + url;
	}
	
	/************************************
	 * 상품 상세 페이지
	 ***********************************/
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public String productDetail(@ModelAttribute AdminProductVO pvo, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		log.info("상품 상세 페이지 호출 성공");
		log.info("p_number = " + pvo.getP_number());

		AdminProductVO detail = new AdminProductVO();
		detail = adminProductService.productDetail(pvo);

		if (detail != null) {
			detail.setP_information(detail.getP_information().toString().replaceAll("\n", "<br>"));
		}

		model.addAttribute("detail", detail);
		model.addAttribute("id", m_id);

		return "admin/product/productDetail";
	}

	/****************************************
	 * 상품 수정 폼
	 ****************************************/
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute AdminProductVO pvo, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		log.info("상품 수정 폼 호출 성공");

		log.info("p_number = " + pvo.getP_number());

		AdminProductVO update = new AdminProductVO();
		update = adminProductService.productDetail(pvo);

		model.addAttribute("update", update);
		model.addAttribute("id", m_id);

		return "admin/product/updateProduct";
	}

	/*********************************
	 * 상품 수정 구현
	 *********************************/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute AdminProductVO pvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		log.info("상품 수정 성공");

		int result = 0;
		String url = "";
		String p_mainphoto = "";
		String p_photo1 = "";
		String p_photo2 = "";
		String p_photo3 = "";

		if (!pvo.getFile().isEmpty()) {
			log.info("======== file = " + pvo.getFile().getOriginalFilename());
			if (!pvo.getP_mainphoto().isEmpty()) {

				FileUploadUtil.fileDelete(pvo.getP_mainphoto(), request);
			}

			p_mainphoto = FileUploadUtil.fileUpload(pvo.getFile(), request, "product");
			pvo.setP_mainphoto(p_mainphoto);
		} else {
			log.info("첨부 파일 없음");
			pvo.setP_mainphoto("");
		}
		if (!pvo.getFile1().isEmpty()) {
			log.info("======== file1 = " + pvo.getFile1().getOriginalFilename());
			if (!pvo.getP_photo1().isEmpty()) {
				
				FileUploadUtil.fileDelete(pvo.getP_photo1(), request);
			}
			
			p_photo1 = FileUploadUtil.fileUpload(pvo.getFile1(), request, "product");
			pvo.setP_photo1(p_photo1);
		} else {
			log.info("첨부 파일 없음");
			pvo.setP_photo1("");
		}
		if (!pvo.getFile2().isEmpty()) {
			log.info("======== file2 = " + pvo.getFile2().getOriginalFilename());
			if (!pvo.getP_photo2().isEmpty()) {
				
				FileUploadUtil.fileDelete(pvo.getP_photo2(), request);
			}
			
			p_photo2 = FileUploadUtil.fileUpload(pvo.getFile2(), request, "product");
			pvo.setP_photo2(p_photo2);
		} else {
			log.info("첨부 파일 없음");
			pvo.setP_photo2("");
		}
		if (!pvo.getFile3().isEmpty()) {
			log.info("======== file3 = " + pvo.getFile3().getOriginalFilename());
			if (!pvo.getP_photo3().isEmpty()) {
				
				FileUploadUtil.fileDelete(pvo.getP_photo3(), request);
			}
			p_photo3 = FileUploadUtil.fileUpload(pvo.getFile3(), request, "product");
			pvo.setP_photo3(p_photo3);
		} else {
			log.info("첨부 파일 없음");
			pvo.setP_photo3("");
		}

		log.info("======== p_mainphoto = " + pvo.getP_mainphoto());
		log.info("======== p_photo1 = " + pvo.getP_photo1());
		log.info("======== p_photo2 = " + pvo.getP_photo2());
		log.info("======== p_photo3 = " + pvo.getP_photo3());
		result = adminProductService.updateProduct(pvo);

		if (result == 1) {
			url = "/admin/product/productDetail?p_number=" + pvo.getP_number();
		}
		return "redirect:" + url;
	}
	
	/****************************
	 * 로그인 체크
	 ***************************/
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response, String message) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("m_id : " + m_id);
		
		if(m_id == null) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('" + message + "');");
			out.println("location.href='/admin/login/login'");
			out.println("</script>");
			out.flush();
		}
	}
}
