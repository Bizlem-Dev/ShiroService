<%-- <!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <title>DWR Thin Chat Version 2.0</title>
  <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'> </script>
  <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/JavaChat.js'> </script>
  <script type="text/javascript">
    function sendMessage() {
      JavaChat.addMessage(dwr.util.getValue("text"));
    }
  </script>
  <script type='text/javascript' src='../tabs/tabs.js'> </script>
  <link rel="stylesheet" type="text/css" href="../tabs/tabs.css" />
  <link rel="stylesheet" type="text/css" href="../generic.css" />
</head>

<body onload="dwr.engine.setActiveReverseAjax(true); Tabs.init('tabList', 'tabContents');">
<div id="page-title">
  <a href="http://getahead.org/dwr/">DWR Website</a> |
  <a href="..">Web Application Index</a>
]</div>

<h1>Java Chat</h1>

<p>This is a very simple chat demo that uses reverse ajax to collect messages
and server-side browser manipulation to update the pages with the results.</p>

<ul id="tabList">
  <li><a href="#" tabId="demoDiv">Demo</a></li>
  <li><a href="#" tabId="explainDiv">How it works</a></li>
  <li><a href="#" tabId="sourceDiv">Source</a></li>
</ul>

<div id="tabContents">

  <div id="demoDiv">
    <p>
      Your Message:
      <input id="text" onkeypress="dwr.util.onReturn(event, sendMessage)"/>
      <input type="button" value="Send" onclick="sendMessage()"/>
    </p>
    <hr/>
    
    <ul id="chatlog" style="list-style-type:none;">
    </ul>
  </div>

  

  

</div>

</body>
</html>
 --%>