const TokenKey = 'libre_token'
const clientKey = 'libre_client'

export function getToken(): string | undefined | null {
  return window.localStorage.getItem(TokenKey)
}

export function setToken(token: string) {
  window.localStorage.setItem(TokenKey, token)
}

export function getClient(): string | undefined | null {
  return window.localStorage.getItem(clientKey)
}

export function setClient(client: string) {
  window.localStorage.setItem(clientKey, client)
}

export function removeToken(): void {
  window.localStorage.removeItem(TokenKey)
}
