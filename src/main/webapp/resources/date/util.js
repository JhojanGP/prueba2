		//script>
		//Highlight form element- © Dynamic Drive (www.dynamicdrive.com)
		//For full source code, 100's more DHTML scripts, and TOS,
		//visit http://www.dynamicdrive.com
		
		var highlightcolor='#FFFFFF'
		
		var ns6=document.getElementById&&!document.all
		var previous=''
		var eventobj
		
		//Regular expression to highlight only form elements
		var intended=/INPUT|TEXTAREA|SELECT|OPTION/
		
		//Function to check whether element clicked is form element
		function checkel(which){
		if (which.style&&intended.test(which.tagName)){
		if (ns6&&eventobj.nodeType==3)
		eventobj=eventobj.parentNode.parentNode
		return true
		}
		else
		return false
		}		
	//Function to highlight form element
		function highlight(e){
		eventobj=ns6? e.target : event.srcElement
		if (previous!=''){
		if (checkel(previous))
		previous.style.backgroundColor=''
		previous=eventobj
		if (checkel(eventobj))
		eventobj.style.backgroundColor=highlightcolor
		}
		else{
		if (checkel(eventobj))
		eventobj.style.backgroundColor=highlightcolor
		previous=eventobj
		}
		}
		// -->
		//script>
		
		//<!Name:animaButton.js>
/*Este .js sirve p' cambiar la apariencia de un button o submit
Ej: <input type="button" name="btnAceptar" value="Aceptar" 
		   fprolloverstyle="color:3300FF;background-color:33CC33;border-color:339933;"
	   	   onmouseover="rollIn(this)" onmouseout="rollOut(this)">*/
function rollIn(el){
		var ms = navigator.appVersion.indexOf("MSIE")
		ie4 = (ms>0) && (parseInt(navigator.appVersion.substring(ms+5, ms+6)) >= 4)
		if(ie4){
			el.initstyle=el.style.cssText;el.style.cssText=el.fprolloverstyle
		}//if
		el.style.cursor = 'hand';
}//rollIn
function rollOut(el){
		var ms = navigator.appVersion.indexOf("MSIE")
		ie4 = (ms>0) && (parseInt(navigator.appVersion.substring(ms+5, ms+6)) >= 4)
		if(ie4){
			el.style.cssText=el.initstyle;
		}//if
}//rollOut

function limpiar(el){
		el.initstyle="";
		el.style.cursor = 'hand';
}
function delay(tiempo){
	for(i=1;i<tiempo;i++);
}

/**/

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}
function MM_nbGroup(event, grpName) { //v6.0
var i,img,nbArr,args=MM_nbGroup.arguments;
  if (event == "init" && args.length > 2) {
    if ((img = MM_findObj(args[2])) != null && !img.MM_init) {
      img.MM_init = true; img.MM_up = args[3]; img.MM_dn = img.src;
      if ((nbArr = document[grpName]) == null) nbArr = document[grpName] = new Array();
      nbArr[nbArr.length] = img;
      for (i=4; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {
        if (!img.MM_up) img.MM_up = img.src;
        img.src = img.MM_dn = args[i+1];
        nbArr[nbArr.length] = img;
    } }
  } else if (event == "over") {
    document.MM_nbOver = nbArr = new Array();
    for (i=1; i < args.length-1; i+=3) if ((img = MM_findObj(args[i])) != null) {
      if (!img.MM_up) img.MM_up = img.src;
      img.src = (img.MM_dn && args[i+2]) ? args[i+2] : ((args[i+1])?args[i+1] : img.MM_up);
      nbArr[nbArr.length] = img;
    }
  } else if (event == "out" ) {
    for (i=0; i < document.MM_nbOver.length; i++) { img = document.MM_nbOver[i]; img.src = (img.MM_dn) ? img.MM_dn : img.MM_up; }
  } else if (event == "down") {
    nbArr = document[grpName];
    if (nbArr) for (i=0; i < nbArr.length; i++) { img=nbArr[i]; img.src = img.MM_up; img.MM_dn = 0; }
    document[grpName] = nbArr = new Array();
    for (i=2; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {
      if (!img.MM_up) img.MM_up = img.src;
      img.src = img.MM_dn = (args[i+1])? args[i+1] : img.MM_up;
      nbArr[nbArr.length] = img;
  } }
}

function MM_preloadImages() { //v3.0 --borrar
 var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
   var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
   if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
/**/