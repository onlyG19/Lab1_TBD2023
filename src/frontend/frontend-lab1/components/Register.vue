<template>
  <form>
    <h1 class="mb-8">Registro de Voluntarios</h1>
    <v-text-field
      v-model="name"
      :error-messages="nameErrors"
      label="Nombre"
      required
      filled
      @input="$v.name.$touch()"
      @blur="$v.name.$touch()"
      ></v-text-field>
    <v-text-field
      v-model="surname"
      :error-messages="surnameErrors"
      label="Apellido"
      required
      filled
      @input="$v.surname.$touch()"
      @blur="$v.surname.$touch()"
      ></v-text-field>
    <v-row>
      <v-col col="12" md="6">
    <v-text-field
      v-model="rut"
      :error-messages="rutErrors"
      label="Rut"
      required
      filled
      @input="$v.rut.$touch()"
      @blur="$v.rut.$touch()"
      ></v-text-field>
      </v-col>
      <v-col col="12" md="6">
    <v-text-field
      v-model="phone"
      :error-messages="phoneErrors"
      label="Teléfono"
      required
      filled
      @input="$v.phone.$touch()"
      @blur="$v.phone.$touch()"
      ></v-text-field>
    </v-col>
    </v-row>
    <v-text-field
      v-model="email"
      :error-messages="emailErrors"
      label="Correo Electrónico"
      required
      filled
      @input="$v.email.$touch()"
      @blur="$v.email.$touch()"
      ></v-text-field>
    <v-text-field
      v-model="address"
      :error-messages="addressErrors"
      label="Dirección"
      required
      filled
      @input="$v.address.$touch()"
      @blur="$v.address.$touch()"
      ></v-text-field>
    <v-text-field
      v-model="birthdate"
      :error-messages="birthdateErrors"
      label="Fecha de nacimiento"
      required
      filled
      @input="$v.birthdate.$touch()"
      @blur="$v.birthdate.$touch()"
      ></v-text-field>
    <v-text-field
      v-model="gender"
      :error-messages="genderErrors"
      label="Género"
      required
      filled
      @input="$v.gender.$touch()"
      @blur="$v.gender.$touch()"
    ></v-text-field>
    <v-text-field
      v-model="password"
      :error-messages="passwordErrors"
      label="Contraseña"
      required
      filled
      @input="$v.password.$touch()"
      @blur="$v.password.$touch()"
      type="password"
    ></v-text-field>
    <v-text-field
      v-model="confirmPassword"
      :error-messages="confirmPasswordErrors"
      label="Confirmar contraseña"
      required
      filled
      @input="$v.confirmPassword.$touch()"
      @blur="$v.confirmPassword.$touch()"
      type="password"
    ></v-text-field>

    <v-btn
      block
      large
      color="primary"
      @click="submit"
    >
      Registrarse
    </v-btn>
  </form>
</template>

<script>
  import { validationMixin } from 'vuelidate'
  import { required, minLength, email, sameAs} from 'vuelidate/lib/validators'
  import {withParams} from 'vuelidate/lib'

  export default{
  mixins: [validationMixin],

  validations: {
    name: {required},
  surname: {required},
  rut: {required},
  email: { required, email },
  phone: {required},
  address: {required},
  birthdate: {required},
  gender: {required},
  password: { required, minLength: minLength(8) },
  confirmPassword: {
  required,
  sameAs: withParams({type: 'password'}, sameAs('password')),
  }
    },

  data (){
    return{
        name: '',
        surname: '',
        email: '',
        rut: '',
        phone: '',
        address: '',
        birthdate: '',
        gender: '',
        password: '',
        confirmPassword: '',
  }
  },
  computed: {

    nameErrors () {
        const errors = []
        if (!this.$v.name.$dirty) return errors
        !this.$v.name.required && errors.push('Se necesita el nombre')
        return errors;
    },
      surnameErrors () {
        const errors = []
        if (!this.$v.surname.$dirty) return errors
        !this.$v.surname.required && errors.push('Se necesita el apellido')
        return errors;
    },
      rutErrors () {
        const errors = []
        if (!this.$v.rut.$dirty) return errors
        !this.$v.rut.required && errors.push('Se necesita el rut')
        return errors;
    },
    emailErrors () {
        const errors = []
        if (!this.$v.email.$dirty) return errors
        !this.$v.email.email && errors.push('El correo debe ser válido')
        !this.$v.email.required && errors.push('Se necesita correo electrónico')
        return errors;
    },
      phoneErrors () {
        const errors = []
        if (!this.$v.phone.$dirty) return errors
        !this.$v.phone.required && errors.push('Se necesita el número de teléfono')
        return errors;
    },
      addressErrors () {
        const errors = []
        if (!this.$v.address.$dirty) return errors
        !this.$v.address.required && errors.push('Se necesita la dirección')
        return errors;
    },
      birthdateErrors () {
        const errors = []
        if (!this.$v.birthdate.$dirty) return errors
        !this.$v.birthdate.required && errors.push('Se necesita fecha de nacimiento')
        return errors;
    },
      genderErrors () {
        const errors = []
        if (!this.$v.gender.$dirty) return errors
        !this.$v.gender.required && errors.push('Se necesita género')
        return errors;
    },
    passwordErrors() {
        const errors = []
        if (!this.$v.password.$dirty) return errors
        !this.$v.password.required && errors.push('Se necesita contraseña')
        !this.$v.password.minLength && errors.push('Contraseña debe tener al menos 8 caracteres')
        return errors
    },
    confirmPasswordErrors () {
        const errors = []
        if (!this.$v.confirmPassword.$dirty) return errors
        !this.$v.confirmPassword.required && errors.push('Se necesita confirmar la contraseña')
        return errors;
    },
    },

  methods: {
    submit () {
        this.$v.$touch()
      },
    },
  }
</script>
