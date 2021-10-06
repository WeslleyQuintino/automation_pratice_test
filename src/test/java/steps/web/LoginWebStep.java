package steps.web;

import io.cucumber.java.pt.Dado;
import pages.HomePage;


public class LoginWebStep {
	private HomePage home = new HomePage();
	
	 @Dado("que esteja na pagina de login")
	    public void que_esteja_na_pagina_de_login() {
		 	home.loginAccess();
	    }
}
