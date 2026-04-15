import { Routes, Route } from 'react-router-dom'
import Layout from './components/layout/Layout'
import HomePage from './pages/HomePage'
import EmergencyPage from './pages/EmergencyPage'
import BloodBankPage from './pages/BloodBankPage'
import HospitalsPage from './pages/HospitalsPage'
import SchemesPage from './pages/SchemesPage'
import LoginPage from './pages/LoginPage'
import RegisterPage from './pages/RegisterPage'

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<HomePage />} />
        <Route path="emergency" element={<EmergencyPage />} />
        <Route path="blood-bank" element={<BloodBankPage />} />
        <Route path="hospitals" element={<HospitalsPage />} />
        <Route path="schemes" element={<SchemesPage />} />
        <Route path="login" element={<LoginPage />} />
        <Route path="register" element={<RegisterPage />} />
      </Route>
    </Routes>
  )
}