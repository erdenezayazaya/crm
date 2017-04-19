<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="../menu/menu.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"  ></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"  ></script>
  <link rel="stylesheet" type="text/css" href="styleForm.css" />

<script type="text/javascript" class="init">
$(document).ready(function() {
    $('#tableSales').DataTable( {
        "ajax": '../ManageSale?action=list', 
        "aoColumns": [
        	{ "data": "idSale" },
            { "data": "typeSale" },
            { "data": "amount" },
            { "data": "percentGain" },
            { "data": "amountGain" }
            ],
            "columnDefs": [
                {
                    "targets": [ 1 ],
                    "visible": true,
                    "searchable": false
                }]
    } );
    
    $('#tableOppor').DataTable( {
    	
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
    
    
    var tableOppor = $('#tableOppor').DataTable();
    $('#tableOppor tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
            
            
        }
        else {
        	tableOppor.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            $("#clientFullName").val(tableOppor.row( this ).data().firstName + " " + tableOppor.row( this ).data().lastName);
            $("#idClient").val(tableOppor.row( this ).data().id);
        }
        
    } );
 
 
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
			    </table>

				<span>&nbsp;</br></span>
				<form name="clientCreation" action="../ManageSale" method="post">
					<ul class="form-style-1">
						<h3>Create New Sale</h3>
							<li>
								<label>Client Name: <span class="required">*</span></label>
								<input type="text" name="clientFullName" id="clientFullName" class="field-divided" placeholder="Select Client"  required />
							</li>
							<li>
								<label>Type Sale: </label> 
								<select name="typeSale">
								  <option value="HEALTHINSURANCE">Health Insurance</option>
								  <option value="CARINSURANCE">Car Insurance</option>
								  <option value="HOMEINSURANCE">Home Insurance</option>
								  <option value="LIFEINSURANCE">Life Insurance</option>
								  <option value="DISABILITYINSURANCE">Disability Insurance</option>
	 						    </select>
	 						</li>
							<li>
								<label>Amount: <span class="required">*</span></label> 
								<input type="number" name="OpporAmount" min="1" max="1000000" required>
							</li>							
							<li>
								<label>Close Date: <span class="required">*</span></label> 
								<input type="date" name="dateSale" required ><br>
							</li>
							<li>
								<input type="submit" value="submit" />
							</li>
							<!-- Action -->	
							<input  type="hidden" value="create" name="action">
							<!-- Value of Id Client --><br>
							<input  type="hidden" value="" name="idClient" id="idClient" required >
							<br>
					</ul>
				</form>
			<h3>Sales</h3>
			<table id="tableSales" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			            	<th>Id</th>
			                <th>Type</th>
			                <th>Amount</th>
			                <th>Percent Gain</th>
			                <th>Amount Gain</th>
			            </tr>
			        </thead>
			        <tfoot>
			            <tr>
			            	<th>Id</th>
			                <th>Type</th>
			                <th>Amount</th>
			                <th>Percent Gain</th>
			                <th>Amount Gain</th>
			            </tr>
			        </tfoot>
			    </table>
			</div>
		</div>
	</div>
</div>





<%@include file="../menu/footer.jsp"%>   