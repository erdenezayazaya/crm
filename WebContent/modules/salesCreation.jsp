<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="../menu/menu.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"  ></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"  ></script>


<script type="text/javascript" class="init">
$(document).ready(function() {
    $('#tableOppor').DataTable( {
	
        "ajax": '../CreateClient?action=listOpportunities',
        "columns": [
        	{ "data": "id" },
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "email" },
            { "data": "stage" },
            { "data": "amount" },
            { "data": "probability" },
            { "data": "closeDate" },
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


$(document).ready(function() {
    $('#tableSales').DataTable( {
	
        "ajax": '../SalesManagement?action=list',
        "columns": [
            { "data": "id" },
            { "data": "typeSale" },
            { "data": "amount" },
            { "data": "percentGain" },
            { "data": "amountGain" },
            { "data": "dateSale" }
            ],
         "columnDefs": [
             {
                 "targets": [ 1 ],
                 "visible": false,
                 "searchable": false
             }]
    } );
} );

//Select row of opprtunity
var tableOppor = $('#tableOppor').DataTable();
 
$('#tableOppor tbody').on( 'click', 'tr', function () {
    console.log( table.row( this ).data() );
} );

</script>


<div id="site_content">
	<div id="content">
		<div class="clear"></div>
			<div class="content_item">
				<div style="width:600px; float:left;">
				<br>
				
							<h3>Opportunities</h3>
			<table id="tableOppor" class="display" cellspacing="0" width="100%">
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
			        
			    </table>

				
				
				
				
				
				
				
				<form name="clientCreation" action="../CreateClient" method="post">
					<h3>Create New Sale</h3>

							<label class="" for="firstname">Type Sale: </label> 
							<select name="typeSale">
							  <option value="HEALTHINSURANCE">Health Insurance</option>
							  <option value="CARINSURANCE">Car Insurance</option>
							  <option value="HOMEINSURANCE">Home Insurance</option>
							  <option value="LIFEINSURANCE">Life Insurance</option>
							  <option value="DISABILITYINSURANCE">Disability Insurance</option>
 						    </select>
							<br>
							<label class="" for="firstname">Amount: </label> 
							<input class="" type="number" name="OpporAmount" min="1" max="1000000" required><br>

							<label class="" for="firstname">Close Date: </label> 
							<input class="" type="date" name="dateSale" ><br>

							<input type="submit" value="submit" />
							<!-- Action -->	
							<input  type="hidden" value="create" name="action">
							<!-- Value of Id Client -->
							<input  type="text" value="" name="idClient">
							<br>
				</form>
				<br>

			<h3>Sales</h3>
			<table id="tableSales" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Type</th>
			                <th>Amount</th>
			                <th>Percent Gain</th>
			                <th>Amount Gain</th>
			                <th>Date</th>
			            </tr>
			        </thead>
			        <tfoot>
			            <tr>
			                <th>Type</th>
			                <th>Amount</th>
			                <th>Percent Gain</th>
			                <th>Amount Gain</th>
			                <th>Date</th>
			            </tr>
			        </tfoot>
			    </table>
			</div>
		</div>
	</div>
</div>





<%@include file="../menu/footer.jsp"%>   