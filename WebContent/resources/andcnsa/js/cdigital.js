$(function(){
	$("#cabecalho .navbar-links .open-content").on("click",function(e){
		e.preventDefault();
		if(!$(this).hasClass("ativo")){
			$("#cabecalho .navbar-links .open-content").removeClass("ativo");
			$(this).toggleClass("ativo");
			$(".drop-content").hide();
			$(this).parent().find(".drop-content").fadeIn(300);
		}else{
			$(this).toggleClass("ativo");
			$(this).parent().find(".drop-content").toggle();
		}
	});
	$("#conteudo").on("click",function(){
		$("#cabecalho .navbar-links .open-content").removeClass("ativo");
		$(".drop-content").hide();
	});
});