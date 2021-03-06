<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../../layouts/taglib.jsp" %>



 <script type="text/javascript">
	$(documnet).ready(function(){
		$(".triggerRemove").click(function(e){
			e.preventDefault();
			$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
			$("#modalRemove").modal();
		})
	});
</script>

<table class="table table-bordered table-haver table-striped">
	<thead>
		<tr><th>user name</th></tr>
		<th>operations</th>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>
					<a href='<spring:url value="/users/${user.id}.html"/>'>
						${user.name}	${user.password}
					</a>
				</td>
				<td>
					<a href='<spring:url value="/users/remove/${user.id}.html"/>' 
					class ="btn btn-danger triggerRemove">
						remove
					</a>
				</td>
			</tr> 
		
		</c:forEach>
	</tbody>
	
	
</table>






<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove test</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-f ooter">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class ="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>