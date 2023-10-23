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
import { required, minLength, email, alphaNum} from 'vuelidate/lib/validators'
import axios from 'axios'

export default {
  mixins: [validationMixin],

  validations: {
    email: { required, email },
    password: { required, minLength: minLength(8), alphaNum},
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
    errorInico: false,
  }),

  computed: {
    emailErrors () {
      const errors = []
      if (!this.$v.email.$dirty) return errors
      !this.$v.email.email && errors.push('El correo debe tener un formato válido (por ejemplo, usuario@dominio.com)')
      !this.$v.email.required && errors.push('El correo electrónico es obligatorio.')
      return errors;
    },
    passwordErrors() {
      const errors = []
      if (!this.$v.password.$dirty) return errors
      !this.$v.password.required && errors.push('La contraseña es obligatoria.')
      !this.$v.password.minLength && errors.push('La contraseña debe tener al menos 8 caracteres.')
      !this.$v.password.alphaNum && errors.push('La contraseña debe ser alphanumerica')
      if(this.errorInico) errors.push('Correo y contraseña incorrectas. Favor de verificar datos.')
      return errors
    },
  },

  methods: {
    async loginUser(){
      this.$v.$touch();
      console.log(this.$v.$invalid);
      if(!this.$v.$invalid) {
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
              if(process.client){
                const token = response.data.token;
                localStorage.setItem("token", token); // Almacena el token en localStorage

                // Almacena la informacion del usuario en sessionStorage
                sessionStorage.setItem("user", JSON.stringify(response.data.usuario));
              }

              this.$router.push("/");
            }

          } catch (error) {
            // Manejo de errores
            console.error('Error durante la solicitud de inicio de sesión:', error);
            this.errorInico = true;
            this.$v.$touch();
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

              if(process.client){
                const token = response.data.token;
                localStorage.setItem("token", token); // Almacena el token en localStorage

                // Almacena la informacion del usuario en sessionStorage
                sessionStorage.setItem("user", JSON.stringify(response.data.usuario));
              }

              this.$router.push("/emergencias");
            }

          } catch (error) {
            // Manejo de errores
            console.error('Error durante la solicitud de inicio de sesión:', error);
            this.errorInico = true;
            this.$v.$touch();
          }
      }

    }
  },
}}
</script>
