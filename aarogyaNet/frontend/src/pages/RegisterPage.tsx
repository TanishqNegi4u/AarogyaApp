import { Link } from 'react-router-dom'
import { useState } from 'react'

export default function RegisterPage() {
  const [form, setForm] = useState({
    fullName: '', email: '', phone: '', password: ''
  })
  const set = (k: string) =>
    (e: React.ChangeEvent<HTMLInputElement>) =>
      setForm(f => ({ ...f, [k]: e.target.value }))

  const inputStyle = {
    padding: '0.75rem', borderRadius: '8px',
    border: '1px solid #ccc', fontSize: '1rem', width: '100%'
  }

  return (
    <main style={{ padding: '2rem', maxWidth: '400px', margin: '0 auto' }}>
      <h1 style={{ color: '#01696f', fontSize: '2rem',
        textAlign: 'center', marginBottom: '2rem' }}>
        Register
      </h1>
      <div style={{ display: 'flex', flexDirection: 'column', gap: '1rem' }}>
        <input placeholder="Full Name"
          value={form.fullName} onChange={set('fullName')} style={inputStyle} />
        <input type="email" placeholder="Email"
          value={form.email} onChange={set('email')} style={inputStyle} />
        <input placeholder="Phone"
          value={form.phone} onChange={set('phone')} style={inputStyle} />
        <input type="password" placeholder="Password"
          value={form.password} onChange={set('password')} style={inputStyle} />
        <button style={{ padding: '0.75rem', background: '#01696f',
          color: 'white', border: 'none', borderRadius: '8px',
          fontSize: '1rem', cursor: 'pointer' }}>
          Create Account
        </button>
        <p style={{ textAlign: 'center', color: '#666' }}>
          Have account? <Link to="/login"
            style={{ color: '#01696f' }}>Login</Link>
        </p>
      </div>
    </main>
  )
}