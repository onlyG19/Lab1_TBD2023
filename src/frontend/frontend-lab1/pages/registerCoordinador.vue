<template>
  <div>
    <div class="btn-container">
      <v-btn
        absolute
        top
        right
        class="mt-4"
        color="white"
        variant="elevated"
        text to="/"
      >Inicio</v-btn>
    </div>
    <fieldset class="form-register">
      <legend style="font-size: 1.5em; padding: 10px; color: #005a85">Registro de Voluntarios</legend>
      <RegisterCoordinador />
    </fieldset>
  </div>
</template>

<script>
export default{
  layout: 'log&reg',
};
</script>

<style scoped>
.form-register{
  width: 30%;
  margin: 30px auto;
  border-radius: 2%;
  border: 2px solid #0097DF;
  padding: 2em;
  margin-bottom: 5rem;
}

.btn-container{
  margin-top: 0;
  margin-bottom: 5rem;
}
.v-btn{
  background-color: rgb(22, 112, 181);
}
</style>
