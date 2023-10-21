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
    <v-row>
      <v-col col="12" md="6">
    <v-text-field
      v-model="form.rut"
      :error-messages="rutErrors"
      label="Rut"
      required
      filled
      dense
      @input="$v.form.rut.$touch()"
      @blur="$v.form.rut.$touch()"
      ></v-text-field>
      </v-col>
      <v-col col="12" md="6">
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
    </v-col>
    </v-row>
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
      v-model="form.gender"
      :error-messages="genderErrors"
      label="Género"
      required
      filled
      dense
      @input="$v.form.gender.$touch()"
      @blur="$v.form.gender.$touch()"
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
  import { validate, clean, format, getCheckDigit } from 'rut.js'
  import {withParams} from 'vuelidate/lib'

  export default{
  mixins: [validationMixin],

      validations: {
          form: {
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
      },
  }
    },

  data (){
      return{
          form: {
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
        },
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
      rutErrors () {
        const errors = []
        if (!this.$v.form.rut.$dirty) return errors
        console.log(validate(this.form.rut))
        !validate(this.form.rut) && errors.push('El rut es inválido')
        !this.$v.form.rut.required && errors.push('Se necesita el rut')
        return errors;
    },
    emailErrors () {
        const errors = []
        if (!this.$v.form.email.$dirty) return errors
        !this.$v.form.email.email && errors.push('El correo debe ser válido')
        !this.$v.form.email.required && errors.push('Se necesita correo electrónico')
        return errors;
    },
      phoneErrors () {
        const errors = []
        if (!this.$v.form.phone.$dirty) return errors
        !this.$v.form.phone.required && errors.push('Se necesita el número de teléfono')
        return errors;
    },
      addressErrors () {
        const errors = []
        if (!this.$v.form.address.$dirty) return errors
        !this.$v.form.address.required && errors.push('Se necesita la dirección')
        return errors;
    },
      birthdateErrors () {
        const errors = []
        if (!this.$v.form.birthdate.$dirty) return errors
        !this.$v.form.birthdate.required && errors.push('Se necesita fecha de nacimiento')
        return errors;
    },
      genderErrors () {
        const errors = []
        if (!this.$v.form.gender.$dirty) return errors
        !this.$v.form.gender.required && errors.push('Se necesita género')
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
    submit () {
        this.$v.$touch()
        const errors = this.nameErrors + this.surnameErrors + this.rutErrors + this.phoneErrors + this.emailErrors + this.addressErrors + this.birthdateErrors + this.genderErrors + this.passwordErrors + this.confirmPasswordErrors;
        console.log(this.$v.$invalid)
        if (!this.$v.form.$invalid){
            const newUser = {nombre: this.name, apellido: this.surname, correo: this.email,
                             rut: format(this.rut), telefono: this.phone, direccion: this.address,
                             nacimiento: this.birthdate, genero: this.gender, contrasenia: this.password};
            console.log(newUser);
            console.log("registrado, maquina");
        }
        else console.log("no registrado");
      },
    },
  }
</script>
