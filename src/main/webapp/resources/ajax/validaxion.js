function validacampo(obj){
    if(obj.value==obj.defaultValue){
        obj.value='';
    }else if(obj.value==''){
        obj.value=obj.defaultValue;
    }
}
limpiar=function(){
	$("#username").val("");
	$("#password").val("");
}
$().ready(function() {
    $("#FormClave").validate({
    rules: {
        clavean: {
        required: true,
        remote: {
        url: "person_check.php",
        type: "post",
        data: {
        opcion: "1",
        usuario: function() {return $("#clavean").val();}
        }
        }
      },
      nuclave: {required: true,minlength: 5},
      rnuclave: {required:true,minlength: 5,equalTo: "#nuclave"}
    },
    messages: {
        clavean:{required:"*",remote:jQuery.format("Incorrecto")},
        nuclave:{required:"*",minlength:"min.5 c"},
        rnuclave:{required:"*",minlength:"min.5 c",equalTo: "p != rp"}
    }
    });
});