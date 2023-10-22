<template>
  <form>
    <h1 class="mb-8">Iniciar Sesión</h1>
    <v-text-field
      v-model="email"
      :error-messages="emailErrors"
      class="mb-12"
      label="Correo Electrónico"
      required
      filled
      @input="$v.email.$touch()"
      @blur="$v.email.$touch()"
    ></v-text-field>
    <v-text-field
      v-model="password"
      :error-messages="passwordErrors"
      label="Contraseña"
      class="mb-12"
      required
      filled
      @input="$v.password.$touch()"
      @blur="$v.password.$touch()"
      type="password"
    ></v-text-field>

    <v-btn block large color="primary" @click.prevent="loginUser">
      Iniciar Sesión
    </v-btn>
  </form>
</template>

<script>
import { validationMixin } from 'vuelidate'
import { required, minLength, email } from 'vuelidate/lib/validators'
import axios from 'axios'

export default {
  mixins: [validationMixin],

  validations: {
    email: { required, email },
    password: { required, minLength: minLength(8) },
  },

  props: {
    typeUser: {
      type: String,
      required: true,
    }
  },

  data: () => ({
    email: '',
    password: '',
  }),

  computed: {
    emailErrors () {
      const errors = []
      if (!this.$v.email.$dirty) return errors
      !this.$v.email.email && errors.push('El correo debe ser válido')
      !this.$v.email.required && errors.push('Se necesita correo electrónico')
      return errors;
    },
    passwordErrors() {
      const errors = []
      if (!this.$v.password.$dirty) return errors
      !this.$v.password.required && errors.push('Se necesita contraseña')
      !this.$v.password.minLength && errors.push('Contraseña debe tener al menos 8 caracteres')
      return errors
    },
  },

  methods: {
    async loginUser(){
      console.log(this.typeUser);
      if (this.typeUser === 'voluntario') { // CASO DE LOGIN VOLUNTARIO
      const userData = {
        email: this.email,
        password: this.password
      };

      try {
        const response = await axios.post("http://localhost:8080/voluntario/login", userData); 
        if (response.status === 200) {
          console.log(response.data.message);
          console.log("Error? : " + response.data.error);

          const token = response.data.token;
          localStorage.setItem("token", token); // Almacena el token en localStorage

          // Almacena la informacion del usuario en sessionStorage
          sessionStorage.setItem("user", JSON.stringify(response.data.usuario));
          console.log('Soy un voluntario');

          this.$router.push("/"); 
        }
        
      } catch (error) {
        // Manejo de errores
        console.error('Error durante la solicitud de inicio de sesión:', error);
      }
    }
    else{   // CASO DE LOGIN COORDINADOR
      const userData = {
        email: this.email,
        password: this.password
      };

      try {
        const response = await axios.post("http://localhost:8080/coordinador/login", userData); 
        if (response.status === 200) {
          console.log("Inicio de sesión exitoso, status 200");
          console.log(response.data.message);
          console.log("Error? : " + response.data.error);

          const token = response.data.token;
          localStorage.setItem("token", token); // Almacena el token en localStorage

          // Almacena la informacion del usuario en sessionStorage
          sessionStorage.setItem("user", JSON.stringify(response.data.usuario));
          console.log('Soy un coordinador');

          this.$router.push("/emergencias"); 
        }
        
      } catch (error) {
        // Manejo de errores
        console.error('Error durante la solicitud de inicio de sesión:', error);
      }

    }
  },
}}
</script>
