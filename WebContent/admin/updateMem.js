/**
 * 
 */

function check(){

	if(form.mname.value == ""){
		alert("�û�������Ϊ�գ�");
		form.mname.focus();
		return false;
	}
	
	var regm = /^[a-z0-9]+$/;
	if(form.mname.value !="" && !form.mname.value.match(regm)){
		alert("�û���ֻ����Сд��ĸ��������ɣ�������������룡");
		form.mname.focus();
		return false;
	}
	
	if(form.mpassword.value == ""){
		alert("���벻�����޸�Ϊ�գ�");
		form.mpassword.focus();
		return false;
	}
	
	var regm = /^[a-zA-Z0-9]+$/;
	if(form.mpassword.value !="" && !form.mpassword.value.match(regm)){
		alert("����ֻ������ĸ��������ɣ�������������룡");
		form.mpassword.focus();
		return false;
	}

}