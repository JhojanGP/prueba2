<%@ include file="/WEB-INF/control/includes.jsp" %>
<html>
<head>
 <title>Logeo</title>

<script type="text/javascript" >
    function setFocus(objPositCur){ $("#"+objPositCur).focus();}
</script>
</head>
<body onload="setFocus('username')" >
            <div class="box">
            <div class="border-right">
            <div class="border-bot">
            <div class="border-left">
            <div class="left-top-corner">
            <div class="right-top-corner">
            <div class="right-bot-corner">
            <div class="left-bot-corner">
                
                   <div class="inner" >
                       <div class="header_01" >Identifiquese por favor: </div>
                    <table border="0" align="center" style="margin: 4px" >
                        
                        

                        <tr>
                                <td colspan='1' height='2'></td>
                        </tr>
                        <tr>
                            <td colspan="1" align="center">
                                <form  method="post" action="javascript:validaxion()" name="fm" >
                                   <table >
                                    <tr>
                                                <td>Usuario:</td>
                                                <td><input type="text" class="myinput" name="username" id="username" size="15" autocomplete="off"/></td>
                                        </tr>
                                        <tr>
                                                <td colspan='2' height='2'></td>
                                        </tr>
                                        <tr>
                                                <td>Clave:</td>
                                                <td><input type="password"  class="myinput" name="password" id="password" size="15" autocomplete="off"/></td>
                                        </tr>
                                        <tr>
                                                <td colspan='2' height='2'></td>
                                        </tr>
                                        <tr >
                                                <td colspan="2"  align="center" >                                                    
                                                    <input type="submit" value="Entrar" class="button2" />&nbsp;&nbsp;
                                                    <input type="button" value="Cerrar" class="button2" onclick="closeMessage()"/>
                                                </td>
                                        </tr>
                                        <tr>
                                        <td colspan="2" >
                                            <div class="myerror" align="center">
                                                    <a id="login_error"></a>
                                                </div>
                                         </td>
                                         </tr>

                                   </table>
                                   </form>
                          </td>
                         </tr>
                        </table>
                        </div>
                </div>
            </div>
            </div>


            </div>
            </div>
            </div>
            </div>
            </div>

</body>
</html>
<script type="text/javascript">
function validaxion(){
     var error = "";
     $('#llave').val("");
	if (!$("#username").val()){
		error += "Introduce el usuario<br>";
		$('#username').focus();
	}
	if (!$("#password").val()){
		error += "Introduce la contraseña";
		if ($("#username").val())
		 $('#password').focus();
	}      
    if(error.length > 0){
	   $("#login_error").html('');
	   $("#login_error").append(error);
	   $("#login_error").slideDown();           
	}else{
	$('#login_error').css('display','none');
	$('#login_cargando').css('display','block');
        var objParameter = "";

        $.ajax({
                type: 'POST',
		url: 'validar/login.html',		
		data: 'username=' + encodeURIComponent($('#username').val()) + '&password=' + encodeURIComponent($('#password').val()) + '&web=validaxion',
		success: function(data){  
                    //alert(data);
                    objParameter=$.trim(data).split("|");                    
                    if($.trim(objParameter[0])=="5"){
                                if($.trim(objParameter[1])=='Exito'){
                                        window.location=$.trim(objParameter[2]);
                                }
                                else {
				$('#login_error').html("Acceso no Autorizado");
				$('#login_error').css('display','block');                                
                                }                         
                         }else{
				$('#login_error').html($.trim(objParameter[1]));
				$('#login_error').css('display','block');
				$('#username').focus();                                
                         } 
            }
         })     
	}
}

</script>

