<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="../menu/menu.jsp"%>


<div id="site_content">
	<div id="content">
		<div class="clear"></div>
		<div class="content_item">
			<div style="width:600px; float:left;">
			<br>
				<form name="clientCreation" action="CreateClient" method="post">
					<h3>Create New Lead</h3>

							<label class="" for="firstname">First name: </label> 
							<input class="" type="text" id="clientFirstName" required><br> 

							<label class="" for="lastname">Last name: </label> 
							<input class="" type="text" id="clientlastname" required><br>

							<label class="" for="lastname">Enter email </label> 
							<input class="" type="email" name="clientEmail" required placeholder="email@example.com" /><br /> 

							<label class="" for="firstname">Source: </label> 
							<input class="" type="text" id="leadSource" required><br>

							<label class="" for="firstname">Status: </label> 
							<input class="" type="text" id="leadStatus" required><br>

							<label class="" for="firstname">amount: </label> 
							<input class="" type="text" id="leadAmount" required><br>

							<label class="" for="firstname">Industry: </label> 
							<input class="" type="text" id="leadDescription" required><br>

							<label class="" for="firstname">Description: </label> 
							<input class="" type="textarea" id="firstname" required><br>

							<input type="submit" value="submit" />	

				</form>

		
			</div>
		</div>
	</div>
</div>



<%@include file="../menu/footer.jsp"%>