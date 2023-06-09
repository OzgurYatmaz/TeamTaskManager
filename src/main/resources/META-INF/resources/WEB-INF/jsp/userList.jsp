    <%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<div>Dear Admin ${name}</div>
		<hr>
		<h1>Here are all the users of the App:</h1>
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Email</th>
					<th>Role</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.count}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.role}</td>
						<td><a type="button" class="btn btn-warning" href="/deleteUser?id=${user.id}"> Delete</a></td>
						<td><a type="button" class="btn btn-success" href="/seeUsersTasks?id=${user.id}&name=${user.name}"> See Users Tasks</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/showAddUserPage" class="btn btn-success"> Add User</a> 
<!-- 		<a href="add-task" class="btn btn-success">Add Task</a> -->
	</div>
	<%@ include file="common/footer.jspf" %>

 	
