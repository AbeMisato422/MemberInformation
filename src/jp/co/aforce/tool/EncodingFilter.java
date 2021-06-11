package jp.co.aforce.tool;





import java.io.IOException;  //import…このプログラム中でIOExceptionといえばこの名前空間のこれを指すよ

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;//
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;//



	@WebFilter(urlPatterns= {"/*"})
	public class EncodingFilter implements Filter{
//filter 1,init 2,doFilter 3,destroy の実装が必要
		public void doFilter(   //HttpServletクラスのメソッド
			ServletRequest request, ServletResponse response, FilterChain chain  //HttpServletResponseインタフェース（クラスじゃない）。（インタフェース…いろんなクラスで使う共通メソッドまとめたもの）
		)throws ServletException, IOException{

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			System.out.println("フィルタの前処理");

			chain.doFilter(request, response);
			System.out.println("フィルタの後処理");
		}

			public void init(FilterConfig filterConfig) {}
			public void destroy() {}
	}


