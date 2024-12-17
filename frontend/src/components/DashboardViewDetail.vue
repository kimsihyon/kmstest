<template>

    <v-card outlined>
        <v-card-title>
            Dashboard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Foodid" v-model="item.foodid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Options" v-model="item.options" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Price" v-model="item.price" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Address" v-model="item.address" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Customerid" v-model="item.customerid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Storeid" v-model="item.storeid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Orderid" v-model="item.orderid" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DashboardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dashboards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

