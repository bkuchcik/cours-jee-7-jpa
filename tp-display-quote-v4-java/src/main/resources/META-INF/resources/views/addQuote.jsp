<form class="form-signin" action="/quotes" method="post">
    <h2 class="form-signin-heading">Contenu</h2>
    <label for="author" class="sr-only">Auteur</label>
    <input id="author" class="form-control" placeholder="Auteur" name="author" required autofocus>
    <br/>
    <label for="content" class="sr-only">Contenu</label>
    <textarea id="content" class="form-control" placeholder="Contenu" name="content"></textarea>
    <br/>

    <button class="btn btn-lg  btn-success btn-block" type="submit">Enregistrer</button>
      <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
</form>

