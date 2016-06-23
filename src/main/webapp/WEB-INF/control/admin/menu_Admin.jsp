<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%String strRootPath = request.getContextPath();%>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<html>
<head>
<style type="text/css">
div.clSlideMenu{ /* All slideMenu2 DIV elements */
	position:absolute;
	font-family:verdana,arial,helvetica;
	font-size:10px;
	overflow:hidden;
	height:22px;
}
a.clA0{ /* All top level links */
	color:white;
	font-size:12px;
	text-decoration:none;
	font-weight:bold;
}
a.clA1{ /* All sub level links */
	color:black;
	font-size:11px;
	font-weight:bold;
	text-decoration:none;
}
a.clA2{ /* All sub2 level links */
	color:navy;
	text-decoration:none;
}
a.clA3{ /* All sub3 level links */
	color:black;
	text-decoration:none;
}
a.clA4{ /* All sub4 level links */
	color:midnightblue;
	text-decoration:none;
}
/* NEEDED STYLES */
div.slideMenuBG{position:absolute; left:0; top:0; z-index:1}
div.slideMenuText{position:absolute; left:2px; top:2px; text-align:left; z-index:200}
#slideMenucont{position:absolute; width:120px; visibility:hidden;}
</style>

<script src="<c:url value="/menu/slidemenu.js"/>" type="text/javascript" ></script>
</head>
<body   style="background-color: #ffffff" marginheight="0" marginleft="0"  >
   
<script type="text/javascript"  >

slideMenu = new createSlideMenu("slideMenu") 

//Variables to set:
slideMenu.menuy=60 //The top placement of the menu.
slideMenu.menux=-30 //The left placement of the menu
slideMenu.useImages = 1 //Are you using images or not?
slideMenu.pxspeed=10 //The pixel speed of the animation
slideMenu.timspeed=10 //The timer speed of the animation
slideMenu.inset = -10 //How much the selected elements should pop to the left
slideMenu.arrow=0;


//Needed dummy classes
slideMenu.bgClass =	"slideMenuBG"
slideMenu.txtClass = "slideMenuText"


//Level properties - ALL properties have to be spesified in level 0
//This works the same way as the CM4 script (if you have seen it)

var directory = "<%=strRootPath%>/menu/";
slideMenu.level[0] = new slideMenu_makeLevel(
	left = 52,
	width = 138,
	height = 21,
	between = 5,
	className = "clSlideMenu",
	classNameA = "clA0",
	regImage = directory+"level0_round.gif",
        roundImg = directory+"level0_round.gif",
	roundImg2 = "",
	subImg = "",
	subRound= "")

    slideMenu.level[1] = new slideMenu_makeLevel(42,127,20,2,"clSlideMenu","clA1",directory+"level1_regular.gif",directory+"level1_round2.gif",directory+"level1_round.gif",directory+"level1_sub.gif", directory+"level1_sub_round.gif")
    slideMenu.level[2] = new slideMenu_makeLevel(33,118,18,2,"clSlideMenu","clA2",directory+"level2_regular.gif",directory+"level2_round2.gif",directory+"level2_round.gif", directory+"level2_sub.gif", directory+"level2_sub_round.gif")
    slideMenu.level[3] = new slideMenu_makeLevel(21,108,20,2,"clSlideMenu","clA3",directory+"level3_regular.gif",directory+"level3_round2.gif",directory+"level3_round.gif",directory+"level3_sub.gif",directory+"level3_sub_round.gif")
    slideMenu.level[4] = new slideMenu_makeLevel(10,107,19,2,"clSlideMenu","clA4",directory+"level4_regular.gif", directory+"level4_round2.gif",directory+"level4_round.gif",directory+"level4_sub.gif", directory+"level4_sub_round.gif")

//Image preload --- leave this
for(var i=0;i<=slideMenu.level;i++){
	var l = slideMenu.level[i]
	new preLoadBackgrounds(l.regImage,l.roundImg,l.roundImg2,l.subImg,l.subRound)
}

/**********************************************************************
mySlideMenu.makeMenu('TYPE','TEXT','LINK','TARGET')
    
    slideMenu.makeMenu('top', 'Periodos');
slideMenu.makeMenu('sub', 'Periodos', 'mainPeriodo.html?fiscalAge', 'main');
************************************************************************/

slideMenu.makeMenu('top' , 'Home', 'home.html', 'main');


slideMenu.makeMenu('top', 'Empleados', 'mainEmpleado.html?empleadoApellido', 'main');
slideMenu.makeMenu('top', 'Productos');

slideMenu.makeMenu('sub', 'Productos', 'mainProducto.html?productoNombre', 'main');
slideMenu.makeMenu('sub', 'Categorias', 'mainCategoria.html?categoriaNombre', 'main');

slideMenu.makeMenu('top', 'Personas');
slideMenu.makeMenu('sub', 'Clientes', 'mainCliente.html', 'main');

slideMenu.makeMenu('top', 'Caja');
slideMenu.makeMenu('sub', 'Resumen de caja', 'mainResumenCaja.html', 'main');



slideMenu.makeMenu('top','Salir','logout.html','_top')


slideMenu.init()
slideMenu.switchMenu(8)
</script>
</body>
</html>
