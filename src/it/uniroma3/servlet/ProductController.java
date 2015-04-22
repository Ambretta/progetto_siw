package it.uniroma3.servlet;



import it.uniroma3.model.Product;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/productController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo i parametri
		boolean ciSonoErrori = false;
		String prossimaPagina = "prodotti.jsp";
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String code = request.getParameter("code");
		String description = request.getParameter("description");

		if (name.isEmpty()){
			ciSonoErrori= true;
			request.setAttribute("nameError", "Campo Obbligatorio");
		}
		if (description.isEmpty()){
			ciSonoErrori= true;
			request.setAttribute("descriptionError", "Campo Obbligatorio");
		}
		if (price.isEmpty()){
			ciSonoErrori= true;
			request.setAttribute("priceError", "Campo Obbligatorio");
		}
		if (code.isEmpty()){
			ciSonoErrori= true;
			request.setAttribute("codeError", "Campo Obbligatorio");
		}
		Float p=null;
		try {
			p= new Float(price);
		} catch(Exception e) {
			ciSonoErrori=true;
			request.setAttribute("priceError", "Valore errato");
		}

		if(ciSonoErrori){
			prossimaPagina = "index.jsp";
		} else {
			HttpSession s= request.getSession();
			Product prodotto=new Product();
			prodotto.setName(name);
			prodotto.setDescription(description);
			prodotto.setPrice(p);
			prodotto.setCode(code);
			List<Product> l;
			l=new LinkedList<Product>();
			if(s.getAttribute("products")!=null){
				l=(LinkedList<Product>) s.getAttribute("products");
			}
			l.add(prodotto);
			s.setAttribute("products", l);
		}

		ServletContext application = getServletContext();
		String urlNextPage = response.encodeURL(prossimaPagina);
		RequestDispatcher rd = application.getRequestDispatcher("/"+urlNextPage);
		rd.forward(request, response);
		return;

	}
}
