<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
            
        $(function()
        {
            $("#button").click(function()
            {
                var html = $("<input type='file' name='file'>");
                var button = $("<input type='button' name='button' value='删除'><br>");
                
                $("#body div").append(html).append(button);
                
                button.click(function()
                {
                    html.remove();
                    button.remove();
                })
            })
        })
    
    </script>
  </head>
  
  <body id="body">

    <form action="WebUserUploadImageAction.action" method="post" enctype="multipart/form-data">
    
        username: <input type="text" name="username"><br>
        file: <input type="file" name="file">
        <input type="button" value="添加" id="button"><br>
        <div></div>
        <input type="submit" value="submit"> 
        
    </form>

  </body>