<%@ page pageEncoding="utf-8" %>
<p style="font-size:22px">未登录或会话超时，请重新登录....</p>
<script>
	window.setTimeout(function(){
		window.open('login.jsp','_parent');
	},1000);
</script>