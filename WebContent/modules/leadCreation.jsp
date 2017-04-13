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
	
        "ajax": '../CreateClient?action=listLeads',
        "columns": [
        	{ "data": "ids" },
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "email" },
            { "data": "source" },
            { "data": "status" },
            { "data": "amount" },
            { "data": "industry" },
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
				<form name="clientCreation" action="../CreateClient" method="post">
					<ul class="form-style-1">
					<h3>Create New Lead</h3>
						<li>
							<label class="" for="firstname">Full Name </label> 
							<input class="" type="text" name="clientFirstName" required placeholder="First">&nbsp;
							<input class="" type="text" name="clientLastName" required placeholder="Last">
						</li>
						<li>
							<label class="" for="lastname">Enter email 
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Source:</label> 
							<input class="" type="email" name="clientEmail" required placeholder="email@example.com" />
							<select name="leadSource" required>
								  <option value=""></option>
								  <option value="CALL">Call</option>
								  <option value="SELFT_GENERATED">Selft Generated</option>
								  <option value="PUBLIC_RELATION">Public Relation</option>
								  <option value="DIRECT_MAIL">Direct Mail</option>
								  <option value="RECYCLED">Recycled</option>
								  <option value="OTHER">Other</option>
	 						    </select>
						</li>

						<li>
							<label class="" for="firstname">Status: 
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;Amount:</label> 
							<select name="leadStatus">
								  <option value="NEW">New</option>
								  <option value="INPROCESS">In Process</option>
								  <option value="CONVERTED">Converted</option>
								  <option value="DEAD">Dead</option>
								  <option value="RECYCLED">Recycled</option>
	 						    </select>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
							<input class="" type="text" name="leadAmount" required>
						</li>
						<li>
							<label class="" for="firstname">Industry: </label> 
							<input class="" type="text" name="leadIndustry" required>
						</li>
						<li>
							<label class="" for="firstname">Description: </label> 
							<textarea name="leadDescription" required rows="4" cols="48"></textarea>
						</li>
						<li>
							<input type="submit" value="submit" />	
							<input class="" type="hidden" value="createLead" name="action">
						</li>
					</ul>
				</form>
				<br>

			<h3>Leads</h3>
			<table id="tableLeads" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			             	<th>Id</th>
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
			            	<th>Id</th>
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