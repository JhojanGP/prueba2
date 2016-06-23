<%!
String f_table_head_modules(int width){
String dmp="";
dmp+="<link type='text/css' rel='stylesheet' href='/Restaurant/resources/css/css_borders.css' />";
dmp+="<link type='text/css' rel='stylesheet' href='/Restaurant/resources/css/css_ioteca.css' />";
dmp+="<table style='margin-right:20px;margin-left:0px; margin-top:30px;' border='0' width='"+width+"%'  cellpadding='0' cellspacing='0'>";
dmp+="<tr>";
dmp+="<td class='fnd_top_left'></td>";
dmp+="<td class='fnd_top_middle'></td>";
dmp+="<td class='fnd_top_right'></td>";
dmp+="</tr>";
dmp+="<tr >";
dmp+="<td class='fnd_middle_left'></td>";
dmp+="<td style='background:white;' width='.$width.' align='center' >";
return dmp;
};
String f_table_foot_modules(){
String dmp="";
dmp+="</td>";
dmp+="<td class='fnd_middle_right'></td>";
dmp+="</tr>";
dmp+="<tr>";
dmp+="<td class='fnd_bottom_left'></td>";
dmp+="<td class='fnd_bottom_middle'></td>";
dmp+="<td class='fnd_bottom_right'></td>";
dmp+="</tr>";
dmp+="</table>";
return dmp;
};
%>



