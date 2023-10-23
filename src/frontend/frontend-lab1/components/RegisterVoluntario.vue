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
      v-model="form.phone"
      :error-messages="phoneErrors"
      label="Teléfono"
      required
      dense
      filled
      @input="$v.form.phone.$touch()"
      @blur="$v.form.phone.$touch()"
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
    <v-text-field
      v-model="form.address"
      :error-messages="addressErrors"
      label="Dirección"
      required
      filled
      dense
      @input="$v.form.address.$touch()"
      @blur="$v.form.address.$touch()"
    ></v-text-field>
    <v-row>
      <v-col col="12" md="6">
        <v-text-field
          v-model="form.birthdate"
          :error-messages="birthdateErrors"
          label="Fecha de nacimiento"
          required
          filled
          dense
          @input="$v.form.birthdate.$touch()"
          @blur="$v.form.birthdate.$touch()"
        ></v-text-field>
      </v-col>
      <v-col col="12" md="6">
        <v-text-field
          v-model="form.disponibilidad"
          :error-messages="disponibilidadErrors"
          label="Disponibilidad"
          required
          filled
          dense
          @input="$v.form.disponibilidad.$touch()"
          @blur="$v.form.disponibilidad.$touch()"
        ></v-text-field>
      </v-col>
    </v-row>
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

    <v-btn block large color="primary" @click.prevent="register">
      Registrarse
    </v-btn>
  </form>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, minLength, email, sameAs } from "vuelidate/lib/validators";
import { withParams } from "vuelidate/lib";
import axios from "axios";

export default {
  mixins: [validationMixin],

  validations: {
    form: {
      name: { required },
      surname: { required },
      email: { required, email },
      phone: { required },
      address: { required },
      birthdate: { required },
      disponibilidad: { required },
      password: { required, minLength: minLength(8) },
      confirmPassword: {
        required,
        sameAs: withParams({ type: "password" }, sameAs("password")),
      },
    },
  },

  data() {
    return {
      form: {
        name: "",
        surname: "",
        email: "",
        phone: "",
        address: "",
        birthdate: "",
        disponibilidad: "",
        password: "",
        confirmPassword: "",
      },
    };
  },
  computed: {
    nameErrors() {
      const errors = [];
      if (!this.$v.form.name.$dirty) return errors;
      !this.$v.form.name.required && errors.push("El nombre es obligatorio.");
      return errors;
    },
    surnameErrors() {
      const errors = [];
      if (!this.$v.form.surname.$dirty) return errors;
      !this.$v.form.surname.required && errors.push("El apellido es obligatorio.");
      return errors;
    },
    emailErrors() {
      const errors = [];
      if (!this.$v.form.email.$dirty) return errors;
      !this.$v.form.email.email && errors.push("El correo debe ser válido.");
      !this.$v.form.email.required &&
        errors.push("El correo electrónico es obligatorio.");
      return errors;
    },
    phoneErrors() {
      const errors = [];
      if (!this.$v.form.phone.$dirty) return errors;
      !this.$v.form.phone.required &&
        errors.push("El número de teléfono es obligatorio.");
      return errors;
    },
    addressErrors() {
      const errors = [];
      if (!this.$v.form.address.$dirty) return errors;
      !this.$v.form.address.required && errors.push("La dirección es obligatoria.");
      return errors;
    },
    birthdateErrors() {
      const errors = [];
      if (!this.$v.form.birthdate.$dirty) return errors;
      !this.$v.form.birthdate.required &&
        errors.push("La fecha de nacimiento es obligatoria.");
      return errors;
    },
    disponibilidadErrors() {
      const errors = [];
      if (!this.$v.form.disponibilidad.$dirty) return errors;
      !this.$v.form.disponibilidad.required &&
        errors.push("La disponibilidad es obligatoria.");
      return errors;
    },
    passwordErrors() {
      const errors = [];
      if (!this.$v.form.password.$dirty) return errors;
      !this.$v.form.password.required && errors.push("La contraseña es obligatoria.");
      !this.$v.form.password.minLength &&
        errors.push("La contraseña debe tener al menos 8 caracteres.");
      return errors;
    },
    confirmPasswordErrors() {
      const errors = [];
      if (!this.$v.form.confirmPassword.$dirty) return errors;
      !this.$v.form.confirmPassword.required &&
        errors.push("La confirmación de contraseña es obligatoria.");
      return errors;
    },
  },

  methods: {
    async register() {

        const newUser = {
          nombre: this.form.name,
          apellido: this.form.surname,
          correo: this.form.email,
          telefono: this.form.phone,
          direccion: this.form.address,
          nacimiento: this.form.birthdate,
          disponibilidad: this.form.disponibilidad,
          contrasenia: this.form.password,
        };
        try {
          const response = await axios.post(
            "http://localhost:8080/voluntario/register",
            newUser
          ); // Cambiado de 'userData' a 'newUser'
          if (response.status === 200) {
            // Registro Exitoso
            console.log("Registro exitoso, status 200");
            console.log(response);
            console.log(response.data.message);
            console.log(response.data.message);
            console.log("Error? : " + response.data.error);
            if(response.data.error == true){
              console.error("Error en el registro");
              this.showMessage = true;
              this.messageText =
              "Error en el registro. Por favor, inténtalo de nuevo.";
              this.messageClass = "error-message";
            }else{
              this.showMessage = true;
              this.messageText = "Registro exitoso.";
              this.messageClass = "success-message";

            }


          } else {
            console.error("Error en el registro");
            this.showMessage = true;
            this.messageText =
              "Error en el registro. Por favor, inténtalo de nuevo.";
            this.messageClass = "error-message";
          }
        } catch (error) {
          console.log("Error en la solicitud, error");
          console.log(error.response.data.message);
          console.log("Error? : " + error.response.data.error);
          this.showMessage = true;
          this.messageText =
            "Error en el registro. Por favor, inténtalo de nuevo.";
          this.messageClass = "error-message";
        }
        // console.log(newUser);
      }
  },

};
</script>
