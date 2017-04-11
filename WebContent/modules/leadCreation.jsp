<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="../menu/menu.jsp"%>

<script type = "text/javascript" language = "javascript">
$(document).ready(function(){
    $.ajax({
       type: "GET",
       url: "../createList?action=listLeads",
       success: function(data) {
            $("#listLeads").autocomplete(data);
       }
    });
});
</script>


<div id="site_content">
	<div id="content">
		<div class="clear"></div>
		<div class="content_item">
			<div style="width:600px; float:left;">
			<br>
				<form name="clientCreation" action="../CreateClient" method="post">
					<h3>Create New Lead</h3>

							<label class="" for="firstname">First name: </label> 
							<input class="" type="text" name="clientFirstName" required><br> 

							<label class="" for="lastname">Last name: </label> 
							<input class="" type="text" name="clientLastName" required><br>

							<label class="" for="lastname">Enter email </label> 
							<input class="" type="email" name="clientEmail" required placeholder="email@example.com" /><br /> 

							<label class="" for="firstname">Source: </label> 
							<input class="" type="text" name="leadSource" required><br>

							<label class="" for="firstname">Status: </label> 
							<input class="" type="text" name="leadStatus" required><br>

							<label class="" for="firstname">amount: </label> 
							<input class="" type="text" name="leadAmount" required><br>

							<label class="" for="firstname">Industry: </label> 
							<input class="" type="text" name="leadIndustry" required><br>

							<label class="" for="firstname">Description: </label> 
							<input class="" type="text" name="leadDescription" required><br>

							<input type="submit" value="submit" />	
							<input class="" type="hidden" name="createLead" ><br>

				</form>

		
			</div>
		</div>
	</div>
</div>


<div id="listLeads"></div>



<%@include file="../menu/footer.jsp"%>