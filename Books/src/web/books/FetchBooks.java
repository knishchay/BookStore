package web.books;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

import web.books.db.ConnectionManager;
import web.books.modal.Books;

/**
 * Servlet implementation class FetchZip
 */
@WebServlet("/fetch.books")
public class FetchBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchBooks() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("test");
		MongoCollection<Document> collection = db.getCollection("Books");
		List<Books> dataList = new ArrayList<>();
		
		
		//String srch=request.getParameter("srch");
		
//		if(srch!=null)
//		{
//			cursor=collection.find(Filters.eq("name",srch)).limit(30).iterator();
//			
//		}
//		else
//		{
//			cursor=collection.find().limit(30).iterator();
//			
//		}
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String authorname=request.getParameter("authorname");
		
		Document document = new Document("name",name)
			.append("price",price)
			.append("authorname", authorname);
		List<Document> docs =new ArrayList<>();
		docs.add(document);
		
		collection.insertMany(docs);
//		Document document1 = new Document("name","ladahadj")
//				.append("price",12123)
//				.append("authorname", "shsajajusj");
		MongoCursor<Document> cursor=collection.find().limit(30).iterator();
		
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();

			Books book = new Books(d.getString("name"), d.getString("price"), d.getString("authorname"));
			dataList.add(book);
		}
		
		
		

		request.setAttribute("list", dataList);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
