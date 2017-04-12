<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="../menu/menu.jsp"%>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"  ></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"  ></script>
<script type="text/javascript" class="init">




$(document).ready(function() {
    $('#tableLeads').DataTable( {
	
        "ajax": '../CreateClient?action=listLeads',
        "columns": [
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "email" },
            { "data": "source" },
            { "data": "status" },
            { "data": "amount" },
            { "data": "industry" },
            { "data": "description" }
            ]
    } );
} );
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
				<br>

			<h3>Leads</h3>
			<table id="tableLeads" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>First Name</th>
			                <th>Last Name</th>
			                <th>Email</th>
			                <th>Source</th>
			                <th>Status</th>
			                <th>Amount</th>
			                <th>Industry</th>
			                <th>Description</th>
			            </tr>
			        </thead>
			        <tfoot>
			            <tr>
			                <th>First Name</th>
			                <th>Last Name</th>
			                <th>Email</th>
			                <th>Source.</th>
			                <th>Status</th>
			                <th>Amount</th>
			                <th>Industry</th>
			                <th>Description</th>
			            </tr>
			        </tfoot>
			    </table>
			</div>
		</div>
	</div>
</div>





<%@include file="../menu/footer.jsp"%>