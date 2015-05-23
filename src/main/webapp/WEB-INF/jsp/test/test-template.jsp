<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../layouts/taglib.jsp"%>

<<style>

	.div

</style>


<h2>${question.description}</h2>

<form:form commandName="item" cssClass="form-horizontal">



	<tbody>
		<c:forEach items="${question.options}" var="option">
			<div class="radio">
				<label> <input type="radio" name="useranswer">
					${option}
				</label>
			</div>
		</c:forEach>
	</tbody>



	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Next" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>




















<nav>
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>








<div class="progress">
	<div class="progress-bar" role="progressbar" aria-valuenow="60"
		aria-valuemin="0" aria-valuemax="100" style="width: 60%;">60%</div>
</div>