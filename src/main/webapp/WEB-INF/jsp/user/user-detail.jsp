<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../layouts/taglib.jsp"%>



<h1>${user.name}</h1>


<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">New test or not</button>



<form:form commandName="test" cssClass="form-horizontal">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Test</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Category:</label>
						<div class="col-sm-10">
							<select name="category" class="form-control">
								<option value="java">Core Java</option>
								<option value="spring">spring</option>
								<option value="hibernate">hibernate</option>
								<option value="struts2">structs</option>
							</select> <br>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Difficult:</label>
						<div class="col-sm-10">
							<select name="difficulty" class="form-control">
								<option value="easy">easy</option>
								<option value="medium">medium</option>
								<option value="hard">hard</option>
							</select>
						</div>
					</div>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Begin Test" />
				</div>
			</div>
		</div>
	</div>
</form:form>


<br>
<br>

<script type="text/javascript">
	$(documnet).ready(function() {
		$('.nav-tabs a:first').tab('show'); // Select first tab
		$(".triggerRemove").click(function(e) {
			e.preventDefault();
			$("#modalRemove.removeBtn").attr("href", $(this).attr("href"));
			$("#modalRemove").modal();
		})
	});
</script>



<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
	<c:forEach items="${user.tests}" var="test">
		<li><a href="#test_${test.id}" data-toggle="tab">${test.category}
		</a></li>
	</c:forEach>
</ul>


<!-- Tab panes -->
<div class="tab-content">
	<c:forEach items="${user.tests}" var="test">
		<div role="tabpanel" class="tab-pane" id="test_${test.id}">
			<h1>${test.category}</h1>

			<a href="<spring:url value="/test/remove/${test.id}.html"/>"
				class="btn btn-danger triggerRemove">Remove test</a>

			<table class="table table-bordered table-haver table-striped">
				<thead>
					<tr>
						<th>Question</th>
						<th>Answer</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${test.items}" var="item">
						<tr>
							<td>${item.question.description}</td>
							<td>${item.useranswer}</td>
						</tr>
					</c:forEach>
				</tbody>


			</table>
		</div>
	</c:forEach>
</div>



