/**
 * 
 */


function check(){
	if(form.wid.value == ""){
		alert("������Ų���Ϊ�գ�");
		form.wid.focus();
		return false;
	}
	
	if(form.wname.value == ""){
		alert("����������Ϊ�գ�");
		form.wname.focus();
		return false;
	}
	
	var regm = /^[0-9]+$/;
	if(form.etime.value !="" && !form.etime.value.match(regm)){
		alert("ʱ���ʽ���ԣ�ֻ����������ɣ�������������룡");
		form.etime.focus();
		return false;
	}
	
	
	var regm = /^[0-9]+$/;
	if(form.atime.value !="" && !form.atime.value.match(regm)){
		alert("ʱ���ʽ���ԣ�ֻ����������ɣ�������������룡");
		form.atime.focus();
		return false;
	}
	
	if(form.etime.value == ""){
		alert("������Ԥ��ʱ�䣡");
		form.etime.focus();
		return false;
	}
	
	if(form.atime.value == ""){
		alert("���������ʱ�䣡");
		form.atime.focus();
		return false;
	}
	
	/*if(form.password1.value != form.password2.value){
		alert("������������벻һ����");
		form.password2.focus("");
		return false;
	}*/
		
}