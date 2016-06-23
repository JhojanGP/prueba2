

(function($) {
	$.fn.validationEngineLanguage = function() {};
	$.validationEngineLanguage = {
		newLang: function() {
			$.validationEngineLanguage.allRules = 	{"required":{    			// Add your regex rules here, you can take telephone as an example
					"regex":"none",
						"alertText":"* Este Campo es Requerido",
						"alertTextCheckboxMultiple":"* Por favor Seleccione una Opci&oacute;n",
						"alertTextCheckboxe":"* Este Checkbox es Requerido"},
					"length":{
						"regex":"none",
						"alertText":"*Entre ",
						"alertText2":" y ",
						"alertText3": " Caracteres Aceptados"},
					"maxCheckbox":{
						"regex":"none",
						"alertText":"* Checkbox Excedidos"},	
					"minCheckbox":{
						"regex":"none",
						"alertText":"* Seleccione Por Favor ",
						"alertText2":" Opciones"},	
					"confirm":{
						"regex":"none",
						"alertText":"* Las Datos no son Id&eacute;nticos"},		
					"telephone":{
						"regex":"/^[0-9\-\(\)\ ]+$/",
						"alertText":"* N&uacute;mero de Tel&eacute;fono Inv&aacute;lido"},	
					"email":{
						"regex":"/^[a-zA-Z0-9_\.\-]+\@([a-zA-Z0-9\-]+\.)+[a-zA-Z0-9]{2,4}$/",
						"alertText":"* Direcci&oacute;n de E-mail Inv&aacute;lido"},	
					"date":{
                         "regex":"/^[0-9]{4}\-\[0-9]{1,2}\-\[0-9]{1,2}$/",
                         "alertText":"* Fecha Inv&aacute;lida, Debe estar con el siguiete Formato YYYY-MM-DD"},
					"onlyNumber":{
						"regex":"/^[0-9\ ]+$/",
						"alertText":"* N&uacute;mero Inv&aacute;lido"},	
					"noSpecialCaracters":{
						"regex":"/^[0-9a-zA-Z]+$/",
						"alertText":"* No Acepta Caracteres Especiales"},	
					"ajaxUser":{
						"file":"validateUser.php",
						"extraData":"name=eric",
						"alertTextOk":"* Este usuario puede usar",	
						"alertTextLoad":"* Leendo, Espere por Favor",
						"alertText":"* Este usuario ya existe "},	
					"ajaxName":{
						"file":"validateUser.php",
						"alertText":"* Este nombre ya existe",
						"alertTextOk":"* Este nombre puede usar",	
						"alertTextLoad":"* Leendo, Por favor espere"},		
					"onlyLetter":{
						"regex":"/^[a-zA-Z\ \']+$/",
						"alertText":"* Texto Inv&aacute;lido"},
					"validate2fields":{
    					"nname":"validate2fields",
    					"alertText":"* Tu tienes un primer nombre y un apellido"}	
					}	
					
		}
	}
})(jQuery);

$(document).ready(function() {	
	$.validationEngineLanguage.newLang()
});