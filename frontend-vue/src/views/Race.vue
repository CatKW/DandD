<template>
  <div class="main">
    <div class = "header">
    <h1 class="title">Dungeons and Dragons: Races</h1>
  </div>

  <router-link to="/race" tag="button" class="button is-primary">Add a Race</router-link>

  <div class="content">
    <table id="race" class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>Race Type</th>
          <th>Race Description</th>
          <th>Additional Detail</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="race in races" :key="race.id">
          <td>{{ race.id }}</td>
          <td>{{ race.name }}</td>
          <td> {{ race.description }}</td>
          <td>{{ race.detail.url }}</td>
        </tr>
      </tbody>
    </table>
  </div>
  </div>
</template>

<script>
export default {
  name: 'Race', 
  data: () => ({
    race: []
  }),
  async mounted() {
    console.log('race mounted being')
    const { data } = await this.$http.get('http://localhost:8080/api/races');
    console.log('race mounted data', data)
    this.race = data;
  }
}
</script>

<style scoped>
button {
  float: right;
}

</style>
