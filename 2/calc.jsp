<html>
  <body>
    <% int n1 = Integer.parseInt(request.getParameter("n1"));
       int n2 = Integer.parseInt(request.getParameter("n2"));
       
       int res = 0;
       switch(request.getParameter("o")) {
        case "a": res = n1 + n2;
            break;
        case "s": res = n1 - n2;
            break;
        case "m": res = n1 * n2;
            break;
        case "d": res = n1 / n2;
            break;
       }
    %>

    <span>result = </span> <%= res %>
  </body>
</html>