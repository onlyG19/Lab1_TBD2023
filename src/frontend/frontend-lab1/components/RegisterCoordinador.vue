<template>
  <form>
    <v-text-field
      v-model="form.name"
      :error-messages="nameErrors"
      label="Nombre"
      required
      filled
      dense
      @input="$v.form.name.$touch()"
      @blur="$v.form.name.$touch()"
    ></v-text-field>
    <v-text-field
      v-model="form.surname"
      :error-messages="surnameErrors"
      label="Apellido"
      required
      dense
      filled
      @input="$v.form.surname.$touch()"
      @blur="$v.form.surname.$touch()"
    ></v-text-field>
    <v-text-field
      v-model="form.email"
      :error-messages="emailErrors"
      label="Correo Electrónico"
      required
      filled
      dense
      @input="$v.form.email.$touch()"
      @blur="$v.form.email.$touch()"
    ></v-text-field>
    <v-select
      v-model="form.institucion"
      :error-messages="institucionErrors"
      :items="instituciones"
      filled
      dense
      required
      @input="$v.form.institucion.$touch()"
      @blur="$v.form.institucion.$touch()"
      label="Institucion"
    ></v-select>
    <v-text-field
      v-model="form.password"
      :error-messages="passwordErrors"
      label="Contraseña"
      required
      filled
      dense
      @input="$v.form.password.$touch()"
      @blur="$v.form.password.$touch()"
      type="password"
    ></v-text-field>
    <v-text-field
      v-model="form.confirmPassword"
      :error-messages="confirmPasswordErrors"
      label="Confirmar contraseña"
      required
      filled
      dense
      @input="$v.form.confirmPassword.$touch()"
      @blur="$v.form.confirmPassword.$touch()"
      type="password"
    ></v-text-field>

    <v-btn
      block
      large
      color="primary"
      @click.prevent="register"
    >
      Registrarse
    </v-btn>
  </form>
</template>

<script>
import { validationMixin } from 'vuelidate'
import { required, minLength, email, sameAs} from 'vuelidate/lib/validators'
import {withParams} from 'vuelidate/lib'
import axios from 'axios'

export default{
  mixins: [validationMixin],

  validations: {
    form: {
      name: {required},
      surname: {required},
      email: { required, email },
      institucion: {required},
      password: { required, minLength: minLength(8) },
      confirmPassword: {
        required,
        sameAs: withParams({type: 'password'}, sameAs('password')),
      },
    }
  },

  data (){
    return{
      form: {
        name: '',
        surname: '',
        email: '',
        institucion: '',
        password: '',
        confirmPassword: '',
      },
      instituciones: [{text: "hole", value: 2 }, {text: "bye", value: 5}],
    }
  },
  computed: {

    nameErrors () {
      const errors = []
      if (!this.$v.form.name.$dirty) return errors
      !this.$v.form.name.required && errors.push('Se necesita el nombre')
      return errors;
    },
    surnameErrors () {
      const errors = []
      if (!this.$v.form.surname.$dirty) return errors
      !this.$v.form.surname.required && errors.push('Se necesita el apellido')
      return errors;
    },
    emailErrors () {
      const errors = []
      if (!this.$v.form.email.$dirty) return errors
      !this.$v.form.email.email && errors.push('El correo debe ser válido')
      !this.$v.form.email.required && errors.push('Se necesita correo electrónico')
      return errors;
    },
    institucionErrors () {
      const errors = []
      if (!this.$v.form.institucion.$dirty) return errors
      !this.$v.form.institucion.required && errors.push('Se necesita la institucion')
      return errors;
    },
    passwordErrors() {
      const errors = []
      if (!this.$v.form.password.$dirty) return errors
      !this.$v.form.password.required && errors.push('Se necesita contraseña')
      !this.$v.form.password.minLength && errors.push('Contraseña debe tener al menos 8 caracteres')
      return errors
    },
    confirmPasswordErrors () {
      const errors = []
      if (!this.$v.form.confirmPassword.$dirty) return errors
      !this.$v.form.confirmPassword.required && errors.push('Se necesita confirmar la contraseña')
      return errors;
    },
  },

  methods: {
    async register () {
      this.$v.$touch()
      const errors = this.nameErrors + this.surnameErrors + this.emailErrors + this.institucionErrors + this.passwordErrors + this.confirmPasswordErrors;
      console.log(this.$v.$invalid)
      if (!errors){
        const newUser = {nombre_coordinador: this.form.name, apellido_coordinador: this.form.surname, email_coordinador: this.form.email,
           id_institucion: this.form.institucion, password_coordinador: this.form.password};
        // try{
        //   const reponse = await axios.post("http//localhost:8080/voluntario/register", userData); // endpoint: /voluntario/register cambiar segun necesidad
        //   if (response.status == 200) {  // Registro Exitoso
        //     console.log("Registro exitoso, status 200");
        //     console.log(response);
        //     console.log(response.data.message);
        //     console.log("Error? : " + response.data.error);

        //     this.showMessage= true;
        //     this.messageText= "Registro exitoso.";
        //     this.messageClass= "success-message";
        //   } else {
        //     console.error("Error en el registro");
        //     this.showMessage = true;
        //     this.messageText = "Error en el registro. Por favor, inténtalo de nuevo.";
        //     this.messageClass = "error-message";
        //   }
        // } catch (error) {
        //   console.log("Error en la solicitud, error");
        //   console.log(error.response.data.message);
        //   console.log("Error? : " + error.response.data.error);
        //   this.showMessage = true;
        //   this.messageText = "Error en el registro. Por favor, inténtalo de nuevo.";
        //   this.messageClass = "error-message";
        // };
        console.log(newUser);
        console.log("registrado, maquina");
      }
      else console.log("no registrado");
    },

    obtenerInstituticones(){
      axios.get(`http://localhost:8080/instituciones`)
        .then(response => {
          this.instituciones = response.data.map(institucion => (
            {text: institucion.nombre_institucion, value: institucion.id_institucion})
          )})
        .catch(error => {
          console.log(error);
        })
    },
  },


  created() {
    this.obtenerInstituticones();
  }
}
</script>
