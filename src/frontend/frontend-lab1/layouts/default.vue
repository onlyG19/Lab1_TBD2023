<template>
<v-app>
    <Navbar @toggleDrawer="drawer = !drawer" />
    <Drawer :drawer="drawer" />
    <v-main>
        <Nuxt />
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import Drawer from "@/components/Drawer.vue";
export default {
  name: "DefaultLayout",
  components: {
    Navbar,
    Drawer
  },
  data() {
    return {
      drawer: false
    };
  },
  methods: {
    toggleDrawer() {
      this.drawer = !this.drawer;
    }
  }
}
</script>
