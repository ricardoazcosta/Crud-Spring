package br.com.ricardocosta.todolist.Filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                // Pegar a autenticação do usuario e senha
                var authorization = request.getHeader("Authorization");
                
                var authEncodee = authorization.substring("Basic".length()).trim();

                byte[] authDecode = Base64.getDecoder().decode(authEncodee);
                
                 var authString = new String(authDecode);
                
                 String[] credentials = authString.split(":");
                 String username = credentials[0];
                 String password = credentials[1];
                 System.out.println("Authorization");
                 System.out.println(username);
                 System.out.println(password);




                // Validar usuario

                //Validar senha

                // Tudo Ok 

       filterChain.doFilter(request, response);
    }

    
    
}
