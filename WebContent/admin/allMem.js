/**
 * 
 */


function allcheck(){
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
/*		ע�ⲻҪд���ʣ�form��from��ture��true��ͨ����ɫ�ı�ɿ���*/
		oCheck[i].checked=true;
	}
}

function delAllMem(){
	var allmid = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
		allmid.push(oCheck[i].value);
		flag = true;
		}
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updateMem?f=delall&allmid="+allmid;
		}
	}else { 
		alert("������Ҫѡ��һ����¼�����ܽ�������ɾ����");
	}
/*	����alert(allmid);������û��ȡ��ID */
}