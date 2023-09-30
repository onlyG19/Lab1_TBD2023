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

    <v-btn
      block
      large
      color="primary"
      @click="submit"
    >
      Iniciar Sesión
    </v-btn>
  </form>
</template>

<script>
  import { validationMixin } from 'vuelidate'
  import { required, minLength, email } from 'vuelidate/lib/validators'

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
      submit () {
        this.$v.$touch()
      },
    },
  }
</script>
