<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>File Download</title>
	    
	    <link rel="stylesheet" href="resource/css/main.css" />
	    <script type="text/javascript" src="resource/js/jquery-3.2.1.min.js"></script>
	    <script type="text/javascript" src="resource/js/fileupload.js"></script>
	</head>
	<body>
	    <div class="panel">
	        <a id="allFiles" class="hyperLink" href="<%=request.getContextPath()%>/uploadedFilesServlet">List all files</a>
	    </div>
	</body>
</html>