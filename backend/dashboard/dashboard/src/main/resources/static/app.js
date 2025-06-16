// Enhanced app.js

document.getElementById('login-form').addEventListener('submit', function(e) {
  e.preventDefault();
  document.querySelector('.login-container').classList.add('hidden');
  document.querySelector('.dashboard').classList.remove('hidden');
  fetchDashboardData(); // Load dashboard data after login
});

document.getElementById('filterButton').addEventListener('click', function() {
  fetchDashboardData();
});

function showLoading(selector) {
  document.querySelector(selector).innerHTML = '<div class="loader"></div>';
}

function hideLoading(selector) {
  document.querySelector(selector).innerHTML = '';
}

function showLoadingCharts() {
  document.getElementById('charts-loader').style.display = 'block';
}
function hideLoadingCharts() {
  document.getElementById('charts-loader').style.display = 'none';
}

function fetchDashboardData() {
  const fromDate = document.getElementById('fromDate').value;
  const toDate = document.getElementById('toDate').value;
  fetchSummary(fromDate, toDate);
  fetchLineChart(fromDate, toDate);
  fetchBarChart(fromDate, toDate);
  fetchProducts(fromDate, toDate);
  fetchRecentOrders();
}

function fetchSummary(fromDate, toDate) {
  // showLoading('#total-sales');  // <-- Remove or comment out this line
  fetch(`/api/summary?from=${fromDate}&to=${toDate}`)
    .then(response => response.json())
    .then(data => updateSummary(data))
    .catch(error => {
      updateSummary({ totalSales: 0, revenue: 0, orders: 0, avgOrder: 0 });
      console.error('Error fetching summary:', error);
    });
}

function fetchLineChart(fromDate, toDate) {
  showLoadingCharts();
  fetch(`/api/chart/line?from=${fromDate}&to=${toDate}`)
    .then(response => response.json())
    .then(data => updateLineChart(data.labels, data.data))
    .catch(error => {
      updateLineChart(["Jan", "Feb", "Mar"], [0, 0, 0]);
      console.error('Error fetching line chart:', error);
    });
}

function fetchBarChart(fromDate, toDate) {
  showLoadingCharts();
  fetch(`/api/chart/bar?from=${fromDate}&to=${toDate}`)
    .then(response => response.json())
    .then(data => updateBarChart(data.labels, data.data))
    .catch(error => {
      updateBarChart(["A", "B", "C"], [0, 0, 0]);
      console.error('Error fetching bar chart:', error);
    });
}

function fetchProducts(fromDate, toDate) {
  fetch(`/api/products?from=${fromDate}&to=${toDate}`)
    .then(response => response.json())
    .then(data => updateTable(data))
    .catch(error => {
      updateTable([]);
      console.error('Error fetching products:', error);
    });
}

// Demo: Recent Orders (replace with backend call if available)
function fetchRecentOrders() {
  const demoOrders = [
    { id: 101, customer: "Alice", amount: 250, date: "2025-06-01" },
    { id: 102, customer: "Bob", amount: 180, date: "2025-06-02" },
    { id: 103, customer: "Charlie", amount: 320, date: "2025-06-03" }
  ];
  updateRecentOrders(demoOrders);
}

function updateSummary(data) {
  document.getElementById('total-sales').innerHTML = `<span>🛒</span> Total Sales: <b>${data.totalSales}</b>`;
  document.getElementById('total-revenue').innerHTML = `<span>💰</span> Total Revenue: <b>$${data.revenue}</b>`;
  document.getElementById('order-count').innerHTML = `<span>📦</span> Orders: <b>${data.orders}</b>`;
  document.getElementById('average-order').innerHTML = `<span>📊</span> Avg Order Value: <b>$${data.avgOrder}</b>`;
}

let lineChartInstance, barChartInstance;

function updateLineChart(labels, data) {
  hideLoadingCharts();
  const canvas = document.getElementById('salesLineChart');
  if (!canvas) return;
  const ctx = canvas.getContext('2d');
  if (lineChartInstance) lineChartInstance.destroy();
  lineChartInstance = new Chart(ctx, {
    type: 'line',
    data: {
      labels: labels,
      datasets: [{
        label: 'Sales Over Time',
        data: data,
        borderColor: '#6C63FF',
        backgroundColor: 'rgba(108, 99, 255, 0.15)',
        pointBackgroundColor: '#6C63FF',
        pointBorderColor: '#fff',
        fill: true,
        tension: 0.4
      }]
    },
    options: {
      responsive: true,
      plugins: { legend: { display: false } }
    }
  });
}

function updateBarChart(labels, data) {
  hideLoadingCharts();
  const canvas = document.getElementById('salesBarChart');
  if (!canvas) return;
  const ctx = canvas.getContext('2d');
  if (barChartInstance) barChartInstance.destroy();
  barChartInstance = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: labels,
      datasets: [{
        label: 'Revenue by Product',
        data: data,
        backgroundColor: [
          'rgba(108, 99, 255, 0.3)',
          'rgba(255, 206, 86, 0.3)',
          'rgba(75, 192, 192, 0.3)',
          'rgba(255, 99, 132, 0.3)'
        ],
        borderColor: [
          '#6C63FF',
          '#FFCE56',
          '#4BC0C0',
          '#FF6384'
        ],
        borderWidth: 2
      }]
    },
    options: {
      responsive: true,
      plugins: { legend: { display: false } }
    }
  });
}

function updateTable(rows) {
  const body = document.getElementById('salesTableBody');
  body.innerHTML = '';
  if (rows.length === 0) {
    body.innerHTML = '<tr><td colspan="4">No data available</td></tr>';
    return;
  }
  rows.forEach(row => {
    const tr = `<tr>
      <td>${row.product}</td>
      <td>${row.units}</td>
      <td>$${row.revenue}</td>
      <td>${row.date}</td>
    </tr>`;
    body.innerHTML += tr;
  });
}

function updateRecentOrders(orders) {
  const body = document.getElementById('recentOrdersBody');
  body.innerHTML = '';
  orders.forEach(order => {
    const tr = `<tr>
      <td>#${order.id}</td>
      <td>${order.customer}</td>
      <td>$${order.amount}</td>
      <td>${order.date}</td>
    </tr>`;
    body.innerHTML += tr;
  });
}

// window.onload = function() {
//   fetchDashboardData();
// };
