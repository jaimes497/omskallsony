package co.com.kallsony.controller;

import java.util.ArrayList;
import java.util.List;

import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.component.UIComponentBase;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

import modelowebserviceseguridad.Menu;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.ui.component.html.HtmlLink;
import org.richfaces.component.html.HtmlDropDownMenu;
import org.richfaces.component.html.HtmlMenuGroup;
import org.richfaces.component.html.HtmlMenuItem;
import org.richfaces.component.html.HtmlToolBar;
import org.richfaces.component.html.HtmlToolBarGroup;

import co.com.kallsonics.Servicios.Negocio.Consulta.xsd.consultaMenu.MenuList;
import co.com.kallsony.bl.entidad.UsuarioLdap;
import co.com.kallsony.dal.controlador.FachadaServicio;


@Name("authenticator")
public class Authenticator {
	private static final int MENU_CLIENTE = 4;

	private static final int MENU_PRODUCTO = 3;

	private static final int MENU_ORDEN = 2;

	private static final int MENU_CAMPANIA = 1;

	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;
	@In(required = false)
	@Out(required = false, scope = ScopeType.SESSION)
	private HtmlToolBar toolBar;
	private List<co.com.kallsonics.Servicios.Negocio.Consulta.xsd.consultaMenu.Menu> mainMenus = new ArrayList<co.com.kallsonics.Servicios.Negocio.Consulta.xsd.consultaMenu.Menu>();
	private FachadaServicio servicio;
	private UsuarioLdap usuario;

	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		servicio = FachadaServicio.getInstance();
		// write your authentication logic here,
		// return true if the authentication was
		// successful, false otherwise
//		if ("admin".equals(credentials.getUsername())) {
//			identity.addRole("admin");
//			return true;
//		}
		
		try {
			usuario = new UsuarioLdap(credentials.getUsername(), credentials.getPassword());
			System.out.println("--> " + usuario);
			String perfil = servicio.obtenerSeguridadServicio().validarLogin(usuario);
			usuario.setPerfil(perfil);
			System.out.println("--> " + usuario);
			//SeguridadServiceProxy proxy = new SeguridadServiceProxy();
			perfil = "123";///proxy.autenticacionAutorizacionLdap(credentials.getUsername(), credentials.getPassword());
			if (!perfil.isEmpty()){
				executeBarMenu(perfil);
				return true;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	private void executeBarMenu(String perfil) {
		this.initToolBar();
		this.getMenuItem(perfil);
	}
	
	public void initToolBar() {
		toolBar = new HtmlToolBar();
		toolBar.setItemSeparator("disc");
		toolBar.setWidth("100%");
		toolBar.setStyle("width:100%;margin: 0 auto;");
		toolBar.setId("tollE");
		toolBar.setHeight("35%"); 
	}
	
	@SuppressWarnings("unchecked")
	public void getMenuItem(String perfil) {
		log.info("menusForUser");
		
		HtmlOutputText projectName = new HtmlOutputText();
		projectName.setValue("");
        toolBar.getChildren().add(projectName);

		
	    HtmlToolBarGroup initialLinks = new HtmlToolBarGroup();
	    FacesContext fc = FacesContext.getCurrentInstance();
		ExpressionFactory ef = fc.getApplication()
				.getExpressionFactory();        
		
        HtmlLink mainLink = new HtmlLink();
        mainLink.setValue("Inicio");
        mainLink.setActionExpression
        (ef.createMethodExpression(fc.getELContext(), "home", null, new Class[0]));
        initialLinks.getChildren().add(mainLink);

        toolBar.getChildren().add(initialLinks);
        
    	HtmlToolBarGroup theme = new HtmlToolBarGroup();
        /*theme.setLocation("left");
		HtmlOutputText usuario=new HtmlOutputText();
		usuario.setId("usuarioNameId");
		usuario.setValue(userSist.getNombre()); 
		theme.getChildren().add(usuario);
           */ 
             
    	try {
    		mainMenus = (List<co.com.kallsonics.Servicios.Negocio.Consulta.xsd.consultaMenu.Menu>) servicio.obtenerSeguridadServicio().obtenerPerfiles(usuario);
            //Menu m = crearMenuManual(MENU_CLIENTE);
            //mainMenus.add(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		log.info("-----El numero de Item son:" + mainMenus.size());

		if (mainMenus.size() > 0) {
			for (int i = 0; i < mainMenus.size(); i++) {
				co.com.kallsonics.Servicios.Negocio.Consulta.xsd.consultaMenu.Menu menu = mainMenus.get(i);
				HtmlDropDownMenu ddm = new HtmlDropDownMenu();
				ddm.setDirection("bottom-right");
				ddm.setSubmitMode("ajax");
				ddm.setValue(menu.getDisplay());	
				
				if(menu.getListadoMenusList()!=null && menu.getListadoMenusList().length>0)
				{  
					this.getSubMenuItem(ddm, menu.getListadoMenusList());
					
					toolBar.getChildren().add(ddm);
				}
				else
				{
					log.info("---- ddm sin opciones no se muestra");
				}
			}
		}
		
//		HtmlToolBarGroup finalLinks = new HtmlToolBarGroup();
//	    FacesContext fc1 = FacesContext.getCurrentInstance();
//		ExpressionFactory ef1 = fc.getApplication()
//				.getExpressionFactory();        
		
//        HtmlLink finalLink = new HtmlLink();
//        finalLink.setValue("Tutorial");
//        finalLink.setActionExpression
//        (ef1.createMethodExpression(fc1.getELContext(), "soporte_perfil", null, new Class[0]));
//        finalLinks.getChildren().add(finalLink);
//       
//        toolBar.getChildren().add(finalLinks);
		
		/*
		//POR EL MOMENTO NO ES NECESARIO
		HtmlLink loginLink = new HtmlLink();
        loginLink.setValue("autenticacion");
        loginLink.setView("/home.xhtml");
        loginLink.setRendered(true);
        loginLink.setRendererType("#{not identity.loggedIn)");
        loginLink.setPropagation("none");
        loginLink.setId("menuLoginId");
          
        
         theme.getChildren().add(loginLink);
        
		HtmlLink loginOutLink = new HtmlLink();
        loginOutLink.setValue("Salir");
        loginOutLink.setActionExpression
        (ef.createMethodExpression(fc.getELContext(), "#{identity.logout}", null, new Class[0]));
        loginOutLink.setId("menuLogoutId");
        loginLink.setView("/homeVisitante.xhtml");
        loginLink.setRendered(true);
        loginLink.setRendererType("#{identity.loggedIn}");
        loginLink.setPropagation("none");

        
        
        theme.getChildren().add(loginOutLink);	
        */
    	toolBar.getChildren().add(theme);
		
		
		
	}

	private Menu crearMenuManual(int tipo) {
		Menu m = new Menu();
		m.setId(1);
		m.setStatus("1");
		Menu[] submenus = null;
		
		if (tipo == MENU_CAMPANIA){
			m.setDisplay("Campaña"); //Campania
			
			submenus = new Menu[1]; //Campaña
			// Campania
			Menu m1 = new Menu();
			m1.setDisplay("Administrar Campaña");
			m1.setAction("admin_campana");
			m1.setId(2);
			m1.setStatus("1");
			submenus[0] = m1;
		} else if (tipo == MENU_ORDEN){
			m.setDisplay("Orden"); //Orden
			
			submenus = new Menu[5]; //Orden
			// Orden
			Menu m1 = new Menu();
			m1.setDisplay("Administrar Orden");
			m1.setAction("admin_orden");
			m1.setId(2);
			m1.setStatus("1");
			submenus[0] = m1;
			m1 = new Menu();
			m1.setDisplay("consultar Cerradas");
			m1.setAction("consultar_cerradas");
			m1.setId(3);
			m1.setStatus("1");
			submenus[1] = m1;
			m1 = new Menu();
			m1.setDisplay("ranking Abiertas");
			m1.setAction("ranking_abiertas");
			m1.setId(3);
			m1.setStatus("1");
			submenus[2] = m1;
			m1 = new Menu();
			m1.setDisplay("ranking Facturas");
			m1.setAction("ranking_facturas");
			m1.setId(3);
			m1.setStatus("1");
			submenus[3] = m1;
			m1 = new Menu();
			m1.setDisplay("actualizar estado");
			m1.setAction("actualizar_estado");
			m1.setId(3);
			m1.setStatus("1");
			submenus[4] = m1;
		} else if (tipo == MENU_PRODUCTO){
			m.setDisplay("Producto"); //Producto
			
			submenus = new Menu[4]; //Producto
			// Producto
			Menu m1 = new Menu();
			m1.setDisplay("Registrar Producto");
			m1.setAction("registrar_producto");
			m1.setId(2);
			m1.setStatus("1");
			submenus[0] = m1;
			m1 = new Menu();
			m1.setDisplay("admin Producto");
			m1.setAction("admin_producto");
			m1.setId(3);
			m1.setStatus("1");
			submenus[1] = m1;
			m1 = new Menu();
			m1.setDisplay("ranking Producto");
			m1.setAction("ranking_producto");
			m1.setId(3);
			m1.setStatus("1");
			submenus[2] = m1;
			m1 = new Menu();
			m1.setDisplay("ranking Categoria");
			m1.setAction("ranking_categoria");
			m1.setId(3);
			m1.setStatus("1");
			submenus[3] = m1;
		} else if (tipo == MENU_CLIENTE){
			m.setDisplay("Cliente"); //Cliente
			
			submenus = new Menu[2]; //Cliente
			// Cliente
			Menu m1 = new Menu();
			m1.setDisplay("admin cliente");
			m1.setAction("admin_cliente");
			m1.setId(2);
			m1.setStatus("1");
			submenus[0] = m1;
			m1 = new Menu();
			m1.setDisplay("ranking facturacion");
			m1.setAction("ranking_facturacion");
			m1.setId(3);
			m1.setStatus("1");
			submenus[1] = m1;

		} else {
			System.out.println("Opcion no valida!!!");
		}		
		m.setListadoMenus(submenus);
		return m;
	}
	
	public void getSubMenuItem(UIComponentBase parent, MenuList[] subSystemMenus) {

		for (int i = 0; i < subSystemMenus.length; i++) {
			MenuList menu = subSystemMenus[i];

			if (menu.getStatus()!=null && menu.getStatus().equals("1")) {
				
				if(true)
				{	 
					HtmlMenuItem menuItem = new HtmlMenuItem();
					menuItem.setValue(menu.getDisplay());
					menuItem.setSubmitMode("ajax");
					
					FacesContext fc = FacesContext.getCurrentInstance();
					ExpressionFactory ef = fc.getApplication()
							.getExpressionFactory();
					if (menu.getAction() != null) {
						MethodExpression methodExpression = ef
								.createMethodExpression(fc.getELContext(), menu
										.getAction(), null, new Class<?>[0]);
						menuItem.setActionExpression(methodExpression);
						//log.info("----menuItem:" + menuItem.getValue());
						parent.getChildren().add(menuItem);
					} else
					{
						log.info("---- MenuItem Action is null id=" + menu.getId());				
					}
				}
				else
				{
					log.info("---- HtmlMenuGroup "+menu.getDisplay());
					HtmlMenuGroup hmg= new HtmlMenuGroup();
					hmg.setValue(menu.getDisplay());					
					getSubMenuItem(hmg,null);
					parent.getChildren().add(hmg);
				}
				
					
			} else
				log.info("---- MenuItem Status = Deshabilitado" + menu.getId());

		}	
	}

}
