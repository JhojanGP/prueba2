function buscarAutocomplete(objText, objUrl, objDiv, objNew ){
    var objDivPar = objDiv.split(",");
       $('#'+objDivPar[0]).val("");
       $('#'+objText).autocomplete(objUrl+"&objBuscado="+$("#"+objText).val(), {
        width: "150px",
        minChars: 1,
        matchSubset:5,
		cacheLength:5
    }).result(function(event,data) {        
        $('#'+objDivPar[0]).css('display','block');
        if(data=="No Existe"){ 
           //location.href='premioForm.php';
            $('#'+objNew).show();
            $('#'+objDivPar[1]).hide();}
        else{$('#'+objNew).hide();
            $('#'+objDivPar[1]).show();}
            $('#'+objDivPar[0]).show();
    });
}
function buscarAutocompleteRezise(objText, objUrl, objDiv, objNew,ObjZise ){
    var objDivPar = objDiv.split(",");
       $('#'+objDivPar[0]).val("");
       $('#'+objText).autocomplete(objUrl+"&objBuscado="+$("#"+objText).val(), {
        width: ObjZise+"px",
        minChars: 1,
        matchSubset:5,
		cacheLength:5
        //delay: 400
    }).result(function(event,data) {
        $('#'+objDivPar[0]).css('display','block');
        if($.trim(data)=="No Existe"){           
            $('#'+objNew).show();
            $('#'+objDivPar[1]).hide();}
        else{$('#'+objNew).hide();
            $('#'+objDivPar[1]).show();}
            $('#'+objDivPar[0]).show();
    });
} 


function listar(objUrl){
location.href=objUrl;
}

//Inicio
   function probandoD(){   
       alert("sssss");
       $.ajax({
        url: "validar.html",        
        data:"opc=e",
        success: function(data){
             alert(data);
        //$("#"+$.trim(campos[1])).html(data);
        }
        });
   }
//Fin

function changeForm(opc, numObj, nameObj){
    var grupoObj = numObj.split(",");
    var nombreObj = nameObj.split(",");
    var i=0;    
    while(i<grupoObj.length){
        if(grupoObj[i]!=opc){
            $('#'+nombreObj[i]).hide();
           }else{$('#'+nombreObj[i]).show("normal");
           }i++;
    }
    }
 


function validarForm(parametro ){
    var campos = parametro.split(",");
    for (x=0; x< campos.length; x++){
    if($.trim(campos[x])!=null && $.trim(campos[x])!=""){
        var divParametro=campos[x].split("|");
            if($.trim(divParametro[0])!=null && $.trim(divParametro[0])!=""){
                if($.trim(divParametro[2])!=null && $.trim(divParametro[2])!=""){
                    if($.trim(divParametro[2])=="T"){while(objText(divParametro[0],"")==false){alert(divParametro[1]);return false;}}else
                    if($.trim(divParametro[2])=="S"){while(objSelect(divParametro[0],"")==false){alert(divParametro[1]);return false;}}else{return true;}
                    //if($.trim(divParametro[2])=="C"){ }
                    //if($.trim(divParametro[2])=="R"){ }
                    //if($.trim(divParametro[2])=="F"){ }
                    //if($.trim(divParametro[2])=="B"){ }
                }else{return false;break;}
            }else{return false;break;}

    }else{return false;break;}
   }
 }

/*
 $().ready(function() {
    $("#validar").validate({
    rules: {
		trabajador_id: {required:true},
		modalidad: {required:true},
		tipo_comprobante: {required:true},
		num_comprobante: {number:true},
		fecha_compra: {required:true},
		persona_compra: {required:true},
		proveedores_id: {required:true},
		cantidad_total: {number:true},
		detalle_estado: {required:true},
		estado: {required:true}
    },
    messages:{
		trabajador_id:{required:"Debe especificar Trabajador"},
		modalidad:{required:"Debe especificar Modalidad"},
		tipo_comprobante:{required:"Debe especificar Tipo de Comprobante"},
		num_comprobante:{number:"Debe ser de tipo N° de Comprobante"},
		fecha_compra:{required:"Debe especificar Fecha de Compra"},
		persona_compra:{required:"Debe especificar Comprador"},
		proveedores_id:{required:"Debe especificar Proveedor"},
		cantidad_total:{number:"Debe ser de tipo numero"},
		detalle_estado:{required:"Debe especificar Detalle del Estado"},
		estado:{required:"Debe especificar Estado"}
    }
    });
});*/

function objText(objtext, objRelation){
        if($.trim(objtext)!=null && $.trim(objtext)!=""){
            if($.trim(objRelation)!=null && $.trim(objRelation)!=""){
                if($.trim($("#"+objtext).val())!=null && $.trim($("#"+objtext).val())!=""){
                    $("#"+objRelation).attr('disabled', false);
                    return true;
                }else{$("#"+objRelation).attr('disabled', true);return false;}
            }else{
                if($.trim($("#"+objtext).val())!=null && $.trim($("#"+objtext).val())!=""){
                    return true;
                }else{return false;}
            }
        }else{return false;}
 }




function objSelect(objSelect, objRelation){
    if($.trim(objSelect)!=null && $.trim(objSelect)!=""){
        if($.trim(objRelation)!=null && $.trim(objRelation)!=""){
            if($.trim($("#"+objSelect).val())!="XX" && $.trim($("#"+objSelect).val())!="XX"){
                $("#"+objRelation).attr('disabled', false);
                return true;
            }else{$("#"+objRelation).attr('disabled', true);return false;}
        }else{
            if($.trim($("#"+objSelect).val())!="XX" && $.trim($("#"+objSelect).val())!="XX"){
                return true;
            }else{return false;}
        }
    }else{return false;}
}

function validarFormEstado(parametro){
    var estado=$("#"+parametro).attr('checked');
    if(estado==true){
         $("#"+parametro).attr('value', 'Activo');
    }else{$("#"+parametro).attr('value', 'Desactivo');
    }
}

function cancelForm(nameForm){
    $("#"+nameForm).submit();
}

function validar(obtFind, divReport, mensajeAccion){
var nombre_buscado=$("#"+obtFind).val();
if(nombre_buscado!="" && nombre_buscado!=null){
            $("#"+divReport).show("normal");
    return true;
  }else{
    $("#"+mensajeAccion).show("normal");    
   return false;
  }
    
}


   function verDetalle(opc, url , parametro, callparameters, e){
       var campos = parametro.split(",");
       $("#"+$.trim(campos[0])).css("top",""+((e.clientY))+"px");
       $("#"+$.trim(campos[0])).css("right",""+40+"px");
       $('#'+$.trim(campos[0])).show('slow');
       var camposParameter = callparameters.split("|");
       var goParameter="";
       for (x=0; x< camposParameter.length; x++){if(x!=0){goParameter+="&"+camposParameter[x];}}       
       $.ajax({
        url: url,
        type: "POST",
        data:"opc="+opc+"&objdata_id="+camposParameter[0]+goParameter,
        success: function(data){
        $("#"+$.trim(campos[1])).html(data);
        }
        });
   }

   function selectDepend(opc, url , htmlObjDisplay, objHtmlCampos){      
       var camposParameter = objHtmlCampos.split("|");        
       var goParameter="";
       for (x=0; x< camposParameter.length; x++){if(x!=0){goParameter+="&"+camposParameter[x]+"="+ $("#"+$.trim(camposParameter[0])).val();}}
       $.ajax({
        url: url,
        type: "POST",
        data:"opc="+opc+"&objdata_id="+$("#"+$.trim(camposParameter[0])).val()+goParameter,
        success: function(data){
        $("#"+htmlObjDisplay).html(data);
        }
        });
   }

   function selectDependReset(objHtmlCampos){
       var camposParameter = objHtmlCampos.split("|");
       for (x=0; x< camposParameter.length; x++){
        $("#"+$.trim(camposParameter[x])).html("<option value='' >Todos</option>");
        }
   }






   function closeX(parametro){
        var campos = parametro.split(",");
        for (x=0; x< campos.length; x++){
        $("#"+campos[x]).hide();
        }
   }

   function submitObjt(formObj){
       $("#"+formObj).submit();
   }
   
   function setFocus(objPositCur){
       $("#"+objPositCur).focus();
   }


   /* function objTextSelect(objtext, objRelation, objMsj){
        if($.trim(objtext)!=null && $.trim(objtext)!=""){
            if($.trim(objRelation)!=null && $.trim(objRelation)!=""){
                if($.trim($("#"+objtext).val())!=null && $.trim($("#"+objtext).val())!=""){
                    $("#"+objRelation).attr('disabled', false);
                }else{$("#"+objRelation).val("XX");
                      $("#"+objRelation).attr('disabled', true);

                  }
            }else{
                if($.trim($("#"+objtext).val())!=null && $.trim($("#"+objtext).val())!=""){
                  return false;
                }else{alert(objMsj)}
            }
        }else{return false;}
    }
     */


/*
    function objSelectDepend(objSelecDepen, objSelect, objRelation, objMsj){
        if($.trim(objSelecDepen)!=null && $.trim(objSelecDepen)!=""){
        if($.trim(objSelect)!=null && $.trim(objSelect)!=""){
            if($.trim(objRelation)!=null && $.trim(objRelation)!=""){
                if($.trim($("#"+objSelect).val())!="XX" && $.trim($("#"+objSelect).val())!="XX"){
                    $("#"+objRelation).attr('disabled', false);
                }else{$("#"+objRelation).attr('disabled', true);}
            }else{
                if($.trim($("#"+objSelecDepen).val())!="XX" && $.trim($("#"+objSelecDepen).val())!="XX"){
                if($.trim($("#"+objSelect).val())!="XX" && $.trim($("#"+objSelect).val())!="XX"){
                  return false;
                }else{alert(objMsj)}
                }else{$("#"+objSelect).attr('disabled', true);}

            }
        }else{return false;}
       } else {return false;}
    }
*/
