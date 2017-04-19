<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="../menu/menu.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"  ></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"  ></script>
  <link rel="stylesheet" type="text/css" href="styleForm.css" />

<script type="text/javascript" class="init">
$(document).ready(function() {
    $('#tableLeads').DataTable( {
	
        "ajax": '../ManageOpportunity?action=list',
        "columns": [
        	{ "data": "id" },
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "email" },
            { "data": "stage" },
            { "data": "amount" },
            { "data": "probability" },
            { "data": "description" }
            ],
            "columnDefs": [
                {
                    "targets": [ 1 ],
                    "visible": false,
                    "searchable": false
                }]
    } );
} );
</script>


<div id="site_content">
	<div id="content">
		<div class="clear"></div>
			<div class="content_item">
				<div style="width:600px; float:left;">
				<br>
				<form name="clientCreation" action="../ManageOpportunity" method="post">
					<ul class="form-style-1">
						<h3>Create New Opportunity</h3>
						<li>
							<label class="" for="firstname">Full Name </label> 
							<input class="" type="text" name="clientFirstName" required placeholder="First">&nbsp;
							<input class="" type="text" name="clientLastName" required placeholder="Last"> 
						<li>
						</li>
							<label class="" for="lastname">Enter email </label> 
							<input size="48" type="email" name="clientEmail" required placeholder="email@example.com" /> 
						<li>
						</li>
							<label class="" for="firstname">Stage: 
							&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;Amount:
							&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Probability:
							</label> 
							<select name="OpporStage">
							  <option value="0">Prospecting</option>
							  <option value="10">Need Analysis</option>
							  <option value="20">Proposal</option>
							  <option value="30">Negotiation</option>
							  <option value="30">Closed Won</option>
							  <option value="30">Closed Lost</option>
							  </select>
							  &nbsp;&emsp;&emsp;
							  <input class="" type="number" name="OpporAmount" min="1" max="1000000" required>
							  &nbsp;&emsp;&emsp;
							  <select name="OpporProbability" >
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
						</li>	  
						<li>
							<label class="" for="firstname">Close Date: </label> 
							<input class="" type="date" name="OpporCloseDate" >
						<li>
						</li>
							<label class="" for="firstname">Description: </label> 
							<textarea name="OpporDescription" cols="49"></textarea>
						<li>
						</li>
							<input type="submit" value="submit" />	
							<input class="" type="hidden" value="create" name="action">
						<li>
					</ul>
				</form>
				<br>

			<h3>Opportunities</h3>
			<table id="tableLeads" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Id</th>
			                <th>First Name</th>
			                <th>Last Name</th>
			                <th>Email</th>
			                <th>Stage</th>
			                <th>Amount</th>
			                <th>Probability</th>
			                <th>Description</th>
			            </tr>
			        </thead>
			        <tfoot>
			            <tr>
			            	<th>Id</th>
			                <th>First Name</th>
			                <th>Last Name</th>
			                <th>Email</th>
			                <th>Stage.</th>
			                <th>Amount</th>
			                <th>Probability</th>
			                <th>Description</th>
			            </tr>
			        </tfoot>
			    </table>
			</div>
		</div>
	</div>
</div>





<%@include file="../menu/footer.jsp"%>   