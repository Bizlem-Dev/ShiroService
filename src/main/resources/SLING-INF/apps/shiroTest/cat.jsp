<%-- <!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <title>DWR Thin Chat Version 2.0</title>
  <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'> </script>
  <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/LoginService.js'> </script>
  <style>
  .show{display:block;}
  .hide{display:none;}
  </style>
  <script type="text/javascript">
    function sendMessage() {
    	LoginService.login(dwr.util.getValue("text"));
    }
    function dwrLoad(){
    	dwr.engine.setActiveReverseAjax(true);
    	
    	dwr.engine.setPollStatusHandler(updatePollStatus);
    	
    	dwr.engine.setErrorHandler(errorHandler);
    	updatePollStatus(true);
    }
    function errorHandler(message, ex) 
    {
    	alert("d")
      //  dwr.util.setValue("error", "Cannot connect to server. Initializing retry logic.", {escapeHtml:false});
       // setTimeout(function() { dwr.util.setValue("error", ""); }, 5000)
        
    }
    function updatePollStatus(pollStatus) 
    {
        dwr.util.setValue("pollStatus", pollStatus ? "Online" : "Offline", {escapeHtml:false});
    }
  </script>

</head>

<body onload="dwrLoad()">


  <div id="demoDiv">
    <p>
      Your Message:
      <input id="text" onkeypress="dwr.util.onReturn(event, sendMessage)"/>
      <input type="button" value="Send" onclick="sendMessage()"/>
    </p>
    <hr/>
    <div id="chatlogon"  class="1 hide" >1online
    </div>
    <div id="chatlogoff" class="1 show" >1ofline
    </div>
    <div id="chatlog2on"  class="1 hide" >2online
    </div>
    <div id="chatlog2off" class="1 show" >2ofline
    </div>
  </div>

  

  

</div>

</body>
</html>
 --%>