import { useState } from 'react'
import { Link } from 'react-router-dom'

export default function LoginPage() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const inputStyle = {
    padding: '0.75rem', borderRadius: '8px',
    border: '1px solid #ccc', fontSize: '1rem', width: '100%'
  }

  return (
    <main style={{ padding: '2rem', maxWidth: '400px', margin: '0 auto' }}>
      <h1 style={{ color: '#01696f', fontSize: '2rem',
        textAlign: 'center', marginBottom: '2rem' }}>
        Login
      </h1>

      <div style={{ display: 'flex', flexDirection: 'column', gap: '1rem' }}>
        <input type="email" placeholder="Email"
          value={email} onChange={e => setEmail(e.target.value)}
          style={inputStyle} />
        <input type="password" placeholder="Password"
          value={password} onChange={e => setPassword(e.target.value)}
          style={inputStyle} />
        <button style={{ padding: '0.75rem', background: '#01696f',
          color: 'white', border: 'none', borderRadius: '8px',
          fontSize: '1rem', cursor: 'pointer' }}>
          Login
        </button>
        <p style={{ textAlign: 'center', color: '#666' }}>
          No account? <Link to="/register"
            style={{ color: '#01696f' }}>Register</Link>
        </p>
      </div>
    </main>
  )
}