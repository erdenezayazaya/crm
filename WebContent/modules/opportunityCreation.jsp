<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="../menu/menu.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"  ></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"  ></script>


<script type="text/javascript" class="init">
$(document).ready(function() {
    $('#tableLeads').DataTable( {
	
        "ajax": '../CreateClient?action=listOpportunities',
        "columns": [
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "email" },
            { "data": "stage" },
            { "data": "amount" },
            { "data": "probability" },
            { "data": "closeDate" },
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
					<h3>Create New Opportunity</h3>

							<label class="" for="firstname">First name: </label> 
							<input class="" type="text" name="clientFirstName" required><br> 

							<label class="" for="lastname">Last name: </label> 
							<input class="" type="text" name="clientLastName" required><br>

							<label class="" for="lastname">Enter email </label> 
							<input class="" type="email" name="clientEmail" required placeholder="email@example.com" /><br /> 

							<label class="" for="firstname">Stage: </label> 
							<select name="OpporStage">
							
							  <option value="0">Prospecting</option>
							  <option value="10">Need Analysis</option>
							  <option value="20">Proposal</option>
							  <option value="30">Negotiation</option>
							  <option value="30">Closed Won</option>
							  <option value="30">Closed Lost</option>
							  </select>
							<br>
							<label class="" for="firstname">Amount: </label> 
							<input class="" type="number" name="OpporAmount" min="1" max="1000000" required><br>

							<label class="" for="firstname">Probability: </label> 
							<!-- <input class="" type="text" name="OpporProbability" required><br> -->
							<select name="OpporProbability">
							
							  <option value="0">0%</option>
							  <option value="10">10%</option>
							  <option value="20">20%</option>
							  <option value="30">30%</option>
							  <option value="40">40%</option>
							  <option value="50">50%</option>
							  <option value="60">60%</option>
							  <option value="70">70%</option>
							  <option value="80">80%</option>
							  <option value="90">90%</option>
							  <option value="100">100%</option>
							  
							</select>
							<br>

							<label class="" for="firstname">Close Date: </label> 
							<input class="" type="date" name="OpporCloseDate" ><br>

							<label class="" for="firstname">Description: </label> 
							<input class="" type="text" name="OpporDescription" ><br>

							<input type="submit" value="submit" />	
							<input class="" type="hidden" value="createLead" name="action"><br>
				</form>
				<br>

			<h3>Opportunities</h3>
			<table id="tableLeads" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>First Name</th>
			                <th>Last Name</th>
			                <th>Email</th>
			                <th>Stage</th>
			                <th>Amount</th>
			                <th>Probability</th>
			                <th>Close Date</th>
			                <th>Description</th>
			            </tr>
			        </thead>
			        <tfoot>
			            <tr>
			                <th>First Name</th>
			                <th>Last Name</th>
			                <th>Email</th>
			                <th>Stage.</th>
			                <th>Amount</th>
			                <th>Probability</th>
			                <th>Close Date</th>
			                <th>Description</th>
			            </tr>
			        </tfoot>
			    </table>
			</div>
		</div>
	</div>
</div>





<%@include file="../menu/footer.jsp"%>   